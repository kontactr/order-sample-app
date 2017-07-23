package com.example.android.intentprac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit(View v)
    {
        Intent i = new Intent(this,RecvData.class);


        i.putExtra("Name",((EditText)findViewById(R.id.name)).getText().toString());
        i.putExtra("Email",((EditText)findViewById(R.id.email)).getText().toString());
        Log.i("Contex  ",getApplicationContext().toString());
        startActivity(i);
    }
}
