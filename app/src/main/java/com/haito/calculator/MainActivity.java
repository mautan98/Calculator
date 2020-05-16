package com.haito.calculator;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	String expression = "";
	String result = "0";
	private TextView expView;
	private TextView resView;
	String l = "";
	Double d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		expView =  findViewById(R.id.exp);
		resView =  findViewById(R.id.res);

		Button zero =  findViewById(R.id.zero);
		zero.setOnClickListener(new MyClickListener());

		Button one =  findViewById(R.id.one);
		one.setOnClickListener(new MyClickListener());

		Button two =  findViewById(R.id.two);
		two.setOnClickListener(new MyClickListener());

		Button three =  findViewById(R.id.three);
		three.setOnClickListener(new MyClickListener());

		Button four =  findViewById(R.id.four);
		four.setOnClickListener(new MyClickListener());

		Button five =  findViewById(R.id.five);
		five.setOnClickListener(new MyClickListener());

		Button six =  findViewById(R.id.six);
		six.setOnClickListener(new MyClickListener());

		Button seven =  findViewById(R.id.seven);
		seven.setOnClickListener(new MyClickListener());

		Button eight =  findViewById(R.id.eight);
		eight.setOnClickListener(new MyClickListener());

		Button nine =  findViewById(R.id.nine);
		nine.setOnClickListener(new MyClickListener());

		Button clean =  findViewById(R.id.clean);
		clean.setOnClickListener(new MyClickListener());

		Button left =  findViewById(R.id.left);
		left.setOnClickListener(new MyClickListener());

		Button right =  findViewById(R.id.right);
		right.setOnClickListener(new MyClickListener());

		Button point =  findViewById(R.id.point);
		point.setOnClickListener(new MyClickListener());

		Button addition =  findViewById(R.id.addition);
		addition.setOnClickListener(new MyClickListener());

		Button subtraction =  findViewById(R.id.subtraction);
		subtraction.setOnClickListener(new MyClickListener());

		Button multiplication =  findViewById(R.id.multiplication);
		multiplication.setOnClickListener(new MyClickListener());

		Button division =  findViewById(R.id.division);
		division.setOnClickListener(new MyClickListener());

		Button equal =  findViewById(R.id.equal);
		equal.setOnClickListener(new MyClickListener());

	}

	class MyClickListener implements OnClickListener {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.zero:
			case R.id.one:
			case R.id.two:
			case R.id.three:
			case R.id.four:
			case R.id.five:
			case R.id.six:
			case R.id.seven:
			case R.id.eight:
			case R.id.nine:
			case R.id.point:
			case R.id.addition:
			case R.id.subtraction:
			case R.id.left:
			case R.id.right:
				expression = expression + (((Button) v).getText());
				result = result + (((Button) v).getText());
				expView.setText(expression);
				break;
			case R.id.multiplication:
				expression = expression + "x";
				result = result + "*";
				expView.setText(expression);
				break;
			case R.id.division:
				expression = expression + ":";
				result = result + "/";
				expView.setText(expression);
				break;
			case R.id.equal:
				try {
					d = new Calculator(result).getRes();
					l = "" + d;
					if (d == -1024 * 1024) {
						resView.setText("Undefined");
						expression = expression + "=";
						expView.setText(expression);
						expression = "";
						result = "0";
					} else {
						resView.setText(l);
						expression = expression + "=";
						expView.setText(expression);
						expression = l;
						result = l;
					}
				} catch (Exception e) {
					resView.setText("Undefined");
					expression = expression + "=";
					expView.setText(expression);
					expression = "";
					result = "0";
				}
				break;
			case R.id.clean:
				expView.setText("0");
				resView.setText("0");
				expression = "";
				result = "0";
				break;
			default:
				break;
			}
		}
	}
}
