package com.example.hussainshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    int card1Count = 0;
    int card2Count = 0;
    int card3Count = 0;
    double priceCard1;
    TextView textViewPriceTotal;
    TextView textViewPrice;
    double priceCard2;
    TextView textViewPriceC2;
    TextView textViewPriceTotalC2;
    TextView textViewQuantity;
    TextView textViewQuantityc2;
    TextView textViewQuantityc3;

    double priceCard3;
    TextView textViewPriceC3;
    TextView textViewPriceTotalC3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        textViewQuantity = findViewById(R.id.textViewQuantity);
        textViewQuantityc2 = findViewById(R.id.textViewQuantityc2);
        textViewQuantityc3 = findViewById(R.id.textViewQuantityc3);
        textViewPriceTotal = findViewById(R.id.textTotalPrice);
        textViewPrice = findViewById(R.id.txtPrice);
        textViewPriceTotalC2 = findViewById(R.id.textViewTotalPriceC2);
        textViewPriceC2 = findViewById(R.id.txtPriceC2);
        textViewPriceTotalC3 = findViewById(R.id.textViewPriceTotalC3);
        textViewPriceC3 = findViewById(R.id.txtPriceC3);

        //if the values aren't null it will retrieve the quantity that was chosen previously.
        if (savedInstanceState != null) {
            card1Count = savedInstanceState.getInt("count");
            textViewQuantity.setText(String.valueOf(card1Count));
            double totalC1 = savedInstanceState.getDouble("price");
            textViewPriceTotal.setText(String.valueOf(totalC1));

            //contents for card2.
            card2Count = savedInstanceState.getInt("countc2");
            textViewQuantityc2.setText(String.valueOf(card2Count));
            double totalc2 = savedInstanceState.getDouble("pricec2");
            textViewPriceTotalC2.setText(String.valueOf(totalc2));

            //Contents of card3.
            card3Count = savedInstanceState.getInt("countc3");
            textViewQuantityc3.setText(String.valueOf(card3Count));
            double totalc3 = savedInstanceState.getDouble("pricec3");
            textViewPriceTotalC3.setText(String.valueOf(totalc3));


        }

    }

 //adds the quantity of  card1
    public void addQuantity(View view) {

        card1Count++;
        if (textViewQuantity != null)
            textViewQuantity.setText(Integer.toString(card1Count));
        priceCard1 = Double.parseDouble(textViewPrice.getText().toString()) * card1Count;
        textViewPriceTotal.setText(Double.toString(priceCard1));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
//subtracts the quantity of card2
    public void subtractQuantity(View view) {
        if (Integer.parseInt(textViewQuantity.getText().toString()) == 0) {
            card1Count = 0;
            Toast.makeText(this, "No Items To Remove.", Toast.LENGTH_LONG).show();
        } else
            --card1Count;
        if (textViewQuantity != null) {
            textViewQuantity.setText(Integer.toString(card1Count));
            priceCard1 = Double.parseDouble(textViewPrice.getText().toString()) * card1Count;
            textViewPriceTotal.setText(Double.toString(priceCard1));
        }
    }
//adds the quantity of card2
    public void addQuantityc2(View view) {
        ++card2Count;
        if (textViewQuantityc2 != null)
            textViewQuantityc2.setText(Integer.toString(card2Count));
        textViewQuantityc2.setText(Integer.toString(card2Count));
        priceCard2 = Double.parseDouble(textViewPriceC2.getText().toString()) * card2Count;
        textViewPriceTotalC2.setText(Double.toString(priceCard2));
    }
    //subtracts the quantity of card2

    public void subtractQuantityc2(View view) {
        if (Integer.parseInt(textViewQuantityc2.getText().toString()) == 0) {
            card2Count = 0;
            Toast.makeText(this, "No Items To Remove.", Toast.LENGTH_LONG).show();
        } else
            --card2Count;
        if (textViewQuantityc2 != null)
            textViewQuantityc2.setText(Integer.toString(card2Count));
        priceCard2 = Double.parseDouble(textViewPriceC2.getText().toString()) * card2Count;
        textViewPriceTotalC2.setText(Double.toString(priceCard2));
    }
//subtracts quantity of card3
    public void subtractQuantityC3(View view) {
        if (Integer.parseInt(textViewQuantityc3.getText().toString()) == 0) {
            card3Count = 0;
            Toast.makeText(this, "No Items To Remove.", Toast.LENGTH_LONG).show();
        } else
            --card3Count;
        if (textViewQuantityc3 != null)
            textViewQuantityc3.setText(Integer.toString(card3Count));
        priceCard3 = Double.parseDouble(textViewPriceC3.getText().toString()) * card3Count;
        textViewPriceTotalC3.setText(Double.toString(priceCard3));
    }
//adds the quantity of card3
    public void addQuantityC3(View view) {
        card3Count++;
        if (textViewQuantityc3 != null)
            textViewQuantityc3.setText(Integer.toString(card3Count));
        priceCard3 = Double.parseDouble(textViewPriceC3.getText().toString()) * card3Count;
        textViewPriceTotalC3.setText(Double.toString(priceCard3));
    }

    // consists of all the contents which are passed through the checkout activity.

    public void CheckOut(View view) {
        //calculates the total quantity of items
        int totalQuantity = Integer.parseInt(textViewQuantity.getText().toString())
                + Integer.parseInt(textViewQuantityc2.getText().toString())
                + Integer.parseInt(textViewQuantityc3.getText().toString());
        Double subTotal = (Double.parseDouble(textViewPrice.getText().toString()) * Double.parseDouble(textViewQuantity.getText().toString()))
                + (Double.parseDouble(textViewPriceC2.getText().toString()) * Double.parseDouble(textViewQuantityc2.getText().toString()))
                + (Double.parseDouble(textViewPriceC3.getText().toString()) * Double.parseDouble(textViewQuantityc3.getText().toString()));
        if (Integer.parseInt(textViewQuantity.getText().toString()) == 0 &&
                Integer.parseInt(textViewQuantityc2.getText().toString()) == 0 && Integer.parseInt(textViewQuantityc3.getText().toString()) == 0) {
            Toast.makeText(getBaseContext(), "No items added in cart.", Toast.LENGTH_LONG).show();
            Log.i("msg", "Toast Message");

        } else {
            //putting the data valus through an intent and a bundle
            Intent intent = new Intent(this, CheckoutActivity.class);
            Bundle b = new Bundle();
            b.putString("Quantity", String.valueOf(totalQuantity));
            b.putString("SubTotal", String.valueOf(subTotal));
            intent.putExtras(b);
            intent.putExtras(b);
            startActivity(intent);
        }
    }
//saves the data when rotating the screen.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", Integer.parseInt(textViewQuantity.getText().toString()));
        outState.putDouble("price", Double.parseDouble(textViewPriceTotal.getText().toString()));
        outState.putInt("countc2", Integer.parseInt(textViewQuantityc2.getText().toString()));
        outState.putDouble("pricec2", Double.parseDouble(textViewPriceTotalC2.getText().toString()));
        outState.putInt("countc3", Integer.parseInt(textViewQuantityc3.getText().toString()));
        outState.putDouble("pricec3", Double.parseDouble(textViewPriceTotalC3.getText().toString()));

    }
//retrieves the data when the screen is rotated.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getInt("count");
        savedInstanceState.getDouble("price");
        savedInstanceState.getInt("countc2");
        savedInstanceState.getDouble("pricec2");
        savedInstanceState.getInt("countc3");
        savedInstanceState.getDouble("pricec3");
    }
}

