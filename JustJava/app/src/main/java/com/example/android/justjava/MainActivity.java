/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 *
 */
package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //String priceMessage ="Total: $" + calculatePrice() + "\n"+"Thank You!!!";
       // displayMessage(createOrderSummary(quantity));
        Log.v("Main Activity: ","Intent Start");
        //Intent intent = new Intent(Intent.ACTION_SEND);
        //intent.setType("*/*");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,"Order Summary!!!");
        intent.putExtra(Intent.EXTRA_TEXT,createOrderSummary(quantity) );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        Log.v("Main Activity: ","Intent Stop");

        // display(quantity);
       // displayPrice(quantity * 5);
    }

    //private void calculatePrice() {
//        int price = quantity * 5;
  //  }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    private String createOrderSummary(int number)
    {
        boolean hasChecked = ((CheckBox)findViewById(R.id.cb_whipped_cream)).isChecked();

        return getString(R.string.Name,((EditText)findViewById(R.id.text_box_name)).getText().toString())  +
            "\n" + getString(R.string.Whipped ,hasChecked)+
                "\n"+ getString(R.string.Chocolate) +" ?" +((CheckBox)findViewById(R.id.cb_chocolate)).isChecked()+
            "\n"+ getString(R.string.quantity)  + " : " + number +
            "\nTotal: " + calculatePrice() + "$" +
            "\n" + getString(R.string.thank_you);
    }

    private int calculatePrice()
    {
        int price = quantity * 5;
        if (((CheckBox)findViewById(R.id.cb_chocolate)).isChecked())
            price += (quantity * 2);
        if (((CheckBox)findViewById(R.id.cb_whipped_cream)).isChecked())
            price += (quantity * 1);
        return (price) ;
    }

    public  void increment(View view){
        if (quantity > 99 )
            Toast.makeText(MainActivity.this, getString(R.string.too_many_coffees), Toast.LENGTH_SHORT).show();
        else
            quantity += 1;
        displayQuantity(""+quantity);
    }

    public  void decrement(View view){
        if(quantity == 1)
            Toast.makeText(MainActivity.this, getString(R.string.too_few_coffees), Toast.LENGTH_SHORT).show();
        else
            quantity = quantity - 1;
        displayQuantity(""+quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(String number1) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number1);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
