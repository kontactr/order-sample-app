package com.example.android.exm;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CheckBox c1;
    String str = "";
    String[] arr = {"1","2","3"};
    String[] arr1 = {"a1","bbbb","cccccc1"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner s1 = (Spinner)findViewById(R.id.sp1);
        ArrayAdapter<String> ab = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,arr1);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);
       // aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // extra
        s1.setAdapter(aa);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str = arr[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        AutoCompleteTextView act = (AutoCompleteTextView)findViewById(R.id.act1);
        act.setAdapter(ab);

    }
    public void tbclick(View v)
    {
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setTitle("Title");
        ab.setMessage("Message");
        ab.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"YES",Toast.LENGTH_SHORT).show();
            }
        });
        ab.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplication(),"NO",Toast.LENGTH_SHORT).show();
            }
        });
        ab.show();



        c1 = (CheckBox)findViewById(R.id.cb);
        if (c1.isChecked())
            str += c1.getText().toString() + getResources().getString(R.string.app_name);

        str += " "+((ToggleButton)findViewById(R.id.tb1)).getText().toString();
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,Main2Activity.class);
        i.putExtra("Value",""+10);
        i.putExtra("Value1",""+20);
        startActivity(i);

    }
}
