package com.example.android.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String input1 = "";
    String input2 = "";
    String operator = "";
    boolean flag = true;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void getNumber(View v) {
        if (flag) {

            Log.i("Calc input", input1);
            input1 += ((Button) v).getText().toString();
            Log.i("Calc input", input1);
            ((TextView)findViewById(R.id.input_text)).setText(input1);
        } else {
            Log.i("Calc input", input2);
            input2 += ((Button) v).getText().toString();
            Log.i("Calc input", input2);
            ((TextView)findViewById(R.id.input_text)).setText(input2);
        }
    }
    public void setOperator(View v)
    {
        flag = false;
        switch (((Button)v).getText().toString())
        {
            case "+":
                operator = "+";
                break;
            case "-":
                operator = "-";
                break;
            case "*":
                operator = "*";
                break;
            case "/":
                operator = "/";
                break;
            default:
                ;
        }
        ((TextView)findViewById(R.id.input_text)).setText(operator);
    }


    public void Calculation(View v) {
        flag = true;
        Log.i("Process_operator", operator);
        TextView tv = (TextView) findViewById(R.id.input_text);
        tv.setText("Done");

        switch (operator) {
            case "+":
                if (input1.contains(".") == false && input2.contains(".") == false)
                {
                    Log.i("Result ","if");
                    tv.setText(String.valueOf(Long.parseLong(input1) + Long.parseLong(input2)));


                }
                else
                {
                    tv.setText(String.valueOf(Double.parseDouble(input1) + Double.parseDouble(input2)));

                }
                break;

            case "-":
                if (input1.contains(".") == false && input2.contains(".") == false)
                {
                    Log.i("Result ","if");
                    tv.setText(String.valueOf(Long.parseLong(input1) - Long.parseLong(input2)));


                }
                else
                {
                    tv.setText(String.valueOf(Double.parseDouble(input1) - Double.parseDouble(input2)));

                }
                break;
            case "*":
                if (input1.contains(".") == false && input2.contains(".") == false)
                {

                    tv.setText(String.valueOf(Long.parseLong(input1) * Long.parseLong(input2)));


                }
                else
                {
                    tv.setText(String.valueOf(Double.parseDouble(input1) * Double.parseDouble(input2)));

                }
                break;

            case "/":
                if (input1.contains(".") == false && input2.contains(".") == false)
                {

                    tv.setText(String.valueOf(Long.parseLong(input1) / Long.parseLong(input2)));


                }
                else
                {
                    tv.setText(String.valueOf(Double.parseDouble(input1) / Double.parseDouble(input2)));

                }
                break;
        }
        input1 = "";
        input2 = "";

    }


    public void process(View v) {

     TextView tv = (TextView)findViewById(R.id.input_text);


     switch (operator)
     {
         case "+":
             if (input1.contains(".") == false && input2.contains(".") == false)
                 tv.setText(Integer.parseInt(input1) + Integer.parseInt(input2));
             else
             {
                 Float res = Float.parseFloat(input1) + Float.parseFloat(input2);
                 tv.setText(res.toString());
             }
             break;

         case "*":
             if (input1.contains(".") == false && input2.contains(".") == false)
                 tv.setText(Integer.parseInt(input1) * Integer.parseInt(input2));
             else
             {
                 Float res = Float.parseFloat(input1) * Float.parseFloat(input2);
                 tv.setText(res.toString());
             }
             break;

         case "-":
             if (input1.contains(".") == false && input2.contains(".") == false)
                 tv.setText(Integer.parseInt(input1) - Integer.parseInt(input2));
             else
             {
                 Float res = Float.parseFloat(input1) - Float.parseFloat(input2);
                 tv.setText(res.toString());
             }
             break;

         case "/":
             if (input1.contains(".") == false && input2.contains(".") == false)
                 tv.setText(Integer.parseInt(input1) / Integer.parseInt(input2));
             else
             {
                 Float res = Float.parseFloat(input1) / Float.parseFloat(input2);
                 tv.setText(res.toString());
             }
             break;
     }
        input1 = "";
        input2 = "";
    }
}
