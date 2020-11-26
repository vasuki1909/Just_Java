package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
   @Override
protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
   }


/**
 * This app displays an order form to order coffee.
 */


    /**
     * This method is called when the order button is clicked.
     */
    int noOfCoffee=0;
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(number);
    }
 //    display(noOfCoffee);
    public void submitOrder(View view) {
         //noOfCoffee=5;
       // display(noOfCoffee);
        //not to be comment  displayPrice(noOfCoffee*100);
        int pri=calculatePrice(noOfCoffee,100);
        createOrderSummary(pri);
    }

    private void createOrderSummary(int price)
        {
            String priceMessage = "Name: Vasuki Rohilla \nQuantity: "+ noOfCoffee+ "\nTotal: ₹"+price+"\nThank you!";
           // priceMessage += "Total: ₹"+ calculatePrice(noOfCoffee, 100)+"\nThank you";
            displayMessage(priceMessage);
        }


    int calculatePrice(int noOfCoffee,int pricePerCoffee)
    {
        int price=noOfCoffee*pricePerCoffee;
        return price;
    }

    public void increment(View view) {
        noOfCoffee++;
        display(noOfCoffee);
      //  displayPrice(noOfCoffee*100);
    }
    public void decrement(View view) {

            noOfCoffee--;
            //if(noOfCoffee>=0)
            display(noOfCoffee);
           // displayPrice(noOfCoffee * 100);

    }


    /**
     * This method displays the given price on the screen.
     */
   // private void displayPrice(int number) {
     //   TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
       // priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    //}

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}