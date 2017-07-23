package com.example.android.intentprac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class RecvData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recv_data);
        Intent i = getIntent();
        Log.i("Contex - 1 ",getApplicationContext().toString());
        ((TextView)findViewById(R.id.name1)).setText("Name: "+i.getStringExtra("Name")+"\n");
        ((TextView)findViewById(R.id.email1)).setText("Email: "+i.getStringExtra("Email")+"\n");
    }
}
