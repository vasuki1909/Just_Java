package com.example.justjava;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;




import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int noOfCoffee=0;


   @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

   }

    public void decrease(View view) {
        if (noOfCoffee <=1) {
            Toast.makeText(this,"You cannot order less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            noOfCoffee = noOfCoffee - 1;
            displayQuantity(noOfCoffee);
        }
    }

    public void increment(View view) {
        if (noOfCoffee == 100) {
            Toast.makeText(this,"You cannot order more than 100 coffees",Toast.LENGTH_SHORT).show();
            return;
        }
        noOfCoffee= noOfCoffee+ 1;
        displayQuantity(noOfCoffee);

    }


    private void displayQuantity(int noOfCoffee) {
        TextView quantityTextview = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextview.setText(""+ noOfCoffee);
    }

    public void submitOrder(View view) {
         //noOfCoffee=5;
       // display(noOfCoffee);
        //not to be comment  displayPrice(noOfCoffee*100);

               CheckBox checkBox=(CheckBox) findViewById(R.id.whipped_cream_checkBox);
               boolean x = checkBox.isChecked();
                 CheckBox checkBox2=(CheckBox) findViewById(R.id.chocolate_checkBox);
                  boolean y = checkBox2.isChecked();
                       int pri=calculatePrice(noOfCoffee,100,x,y);
                     EditText editText= (EditText) findViewById(R.id.name);
        String name= editText.getText().toString();
        //Log.v("MainActivity","The price is "+pri);


        String priceMessage=   createOrderSummary(pri,x,y,name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java app for "+name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }


    private String createOrderSummary(int price, boolean x, boolean y, String name)
        {
            String priceMessage = getString(R.string.name)+name+getString(R.string.addwhippedcream)+x+getString(R.string.addchoco)+y+"\n"+getString(R.string.quantiry)+ noOfCoffee+ getString(R.string.total)+price+"\n"+getString(R.string.thank_you);
           // priceMessage += "Total: ₹"+ calculatePrice(noOfCoffee, 100)+"\nThank you";
return priceMessage;
        }


    int calculatePrice(int noOfCoffee,int pricePerCoffee,boolean x, boolean y)
    {

        if(x)
            pricePerCoffee+=20;
        if(y)
            pricePerCoffee+=10;
        int price=noOfCoffee*pricePerCoffee;
        return price;
    }


   /* public void decrement(View view) {

            noOfCoffee--;
            //if(noOfCoffee>=0)
         displays(noOfCoffee);
           // displayPrice(noOfCoffee * 100);

    }*/




}