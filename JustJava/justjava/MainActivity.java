package com.example.android.justjava;

import android.widget.TextView;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.TextView;

import java.text.NumberFormat;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 0;
    public void increase (View view) {
        quantity = quantity + 1;
        display(quantity);
    }
    public void decrease (View view) {
        quantity = quantity - 1;

        display(quantity);
    }
// WHEN ORDER BUTTON IS CLICKED
    public void submitOrder(View view) {

        // FIND THE USERs NAME
        EditText edit = (EditText) findViewById(R.id.name) ;
        boolean names = edit.getText().toString().isEmpty() ;

        // WHEN USER WANTS CREAM
        CheckBox creamcheckbox =(CheckBox) findViewById(R.id.cream);
        boolean checked = creamcheckbox.isChecked();

        // WHEN USER WANTS CHOCO
        CheckBox chocos =(CheckBox) findViewById(R.id.choco);
        boolean checked2 = chocos.isChecked();


        int price = calculatePrice(checked,checked2);
        String priceMessage = creatOrder(names,price,checked,checked2);
        displayMessage(priceMessage);
    }

    // CALCULATE THE ORDER PRICE
    private int calculatePrice(boolean addcream, boolean addchoco) {
        int basePrice =5;

        if (addcream){
            basePrice = basePrice + 1 ;
        }
        if (addchoco){
            basePrice = basePrice + 2 ;
        }
        return quantity * basePrice ;
    }

// PRESS ORDER BUTTON
        private String creatOrder(boolean names, int price, boolean checked, boolean checked2) {

        String priceMessage = "Total= $" + price ;
        priceMessage += "\nName: " + names;
        priceMessage += "\nhas whipped cream: ";
        priceMessage+= checked;
        priceMessage += "\nhas Chocolate: ";
        priceMessage+= checked2;

        displayMessage (priceMessage);
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);

    }

}
