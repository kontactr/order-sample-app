package com.example.android.examprac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View v)
    {
        EditText et1 = (EditText)findViewById(R.id.et1);
        EditText et2 = (EditText)findViewById(R.id.et2);
        Toast.makeText(getApplicationContext(),""+(Integer.parseInt(et1.getText().toString()) +
                Integer.parseInt(et2.getText().toString())),Toast.LENGTH_LONG);
        String str = "";
        (CheckBox)findViewById(R.id.cb1);


    }
}
