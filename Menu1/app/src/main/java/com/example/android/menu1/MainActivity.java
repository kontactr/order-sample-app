package com.example.android.menu1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs

        // Find second menu item TextView and print the text to the logs

        // Find third menu item TextView and print the text to the logs
        Log.i("Log_id_1", (String) ((TextView)findViewById(R.id.menu_item_1)).getText());
        Log.i("Log_id_2" , (String) ((TextView)findViewById(R.id.menu_item_2)).getText());
        Log.i("Log_id_3" , (String) ((TextView)findViewById(R.id.menu_item_3)).getText());
    }
}
