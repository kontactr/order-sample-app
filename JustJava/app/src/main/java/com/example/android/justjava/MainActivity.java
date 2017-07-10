/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 *
 */
package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

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
        displayMessage(createOrderSummary(quantity));

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
        return "Name: Yash Gandhi" +
            "\nQuantity: " + number +
            "\nTotal: " + calculatePrice() + "$" +
            "\nThank You!";
    }

    private int calculatePrice()
    {
        return (quantity * 5);
    }

    public  void increment(View view){

        quantity = 1 + quantity ;
        displayQuantity(""+quantity);
    }

    public  void decrement(View view){

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
