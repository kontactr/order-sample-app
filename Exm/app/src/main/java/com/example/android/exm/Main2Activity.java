package com.example.android.exm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        Toast.makeText(this,i.getStringExtra("Value"),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,i.getStringExtra("Value1"),Toast.LENGTH_SHORT).show();
    }
}
