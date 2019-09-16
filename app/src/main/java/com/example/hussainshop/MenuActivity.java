package com.example.hussainshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    int card1Count=0;
    int card2Count=0;
    int card3Count=0;
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
        textViewQuantity =findViewById(R.id.textViewQuantity);
        textViewQuantityc2 = findViewById(R.id.textViewQuantityc2);
        textViewQuantityc3 = findViewById(R.id.textViewQuantityc3);
        textViewPriceTotal = findViewById(R.id.textTotalPrice);
        textViewPrice = findViewById(R.id.txtPrice);
        textViewPriceTotalC2 = findViewById(R.id.textViewTotalPriceC2);
        textViewPriceC2 = findViewById(R.id.txtPriceC2);
        textViewPriceTotalC3= findViewById(R.id.textViewPriceTotalC3);
        textViewPriceC3 = findViewById(R.id.txtPriceC3);

    }

    public void addQuantity(View view) {

        card1Count++;
        if(textViewQuantity!=null)
            textViewQuantity.setText(Integer.toString(card1Count));
        priceCard1= Double.parseDouble(textViewPrice.getText().toString())* card1Count;
        textViewPriceTotal.setText(Double.toString(priceCard1));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void subtractQuantity(View view) {
       --card1Count;
        if(textViewQuantity!=null ){
            textViewQuantity.setText(Integer.toString(card1Count));
            priceCard1= Double.parseDouble(textViewPrice.getText().toString())* card1Count;
            textViewPriceTotal.setText(Double.toString(priceCard1));
        }
    }

    public void addQuantityc2(View view) {
        ++card2Count;
        if(textViewQuantityc2!=null)
            textViewQuantityc2.setText(Integer.toString(card2Count));
        textViewQuantityc2.setText(Integer.toString(card2Count));
        priceCard2= Double.parseDouble(textViewPriceC2.getText().toString())* card2Count;
        textViewPriceTotalC2.setText(Double.toString(priceCard2));
    }
    public void subtractQuantityc2(View view) {
        --card2Count;
        if(textViewQuantityc2!=null)
            textViewQuantityc2.setText(Integer.toString(card2Count));
        priceCard2= Double.parseDouble(textViewPriceC2.getText().toString())* card2Count;
        textViewPriceTotalC2.setText(Double.toString(priceCard2));
    }
    public void subtractQuantityC3(View view) {
        --card3Count;
        if(textViewQuantityc3!=null)
           textViewQuantityc3.setText(Integer.toString(card3Count));
        priceCard3= Double.parseDouble(textViewPriceC3.getText().toString())* card3Count;
        textViewPriceTotalC3.setText(Double.toString(priceCard3));
    }

    public void addQuantityC3(View view) {
        card3Count++;
        if(textViewQuantityc3!=null)
            textViewQuantityc3.setText(Integer.toString(card3Count));
        priceCard3= Double.parseDouble(textViewPriceC3.getText().toString())* card3Count;
        textViewPriceTotalC3.setText(Double.toString(priceCard3));
    }



    public void CheckOut(View view) {
        int total = Integer.parseInt(textViewQuantity.getText().toString())
                    + Integer.parseInt(textViewQuantityc2.getText().toString())
                    + Integer.parseInt(textViewQuantityc3.getText().toString());
        int subTotal= (Integer.parseInt(textViewPrice.getText().toString())*Integer.parseInt(textViewQuantity.getText().toString()))+
                (Integer.parseInt(textViewPriceC2.getText().toString())*Integer.parseInt(textViewQuantityc2.getText().toString()))
                +(Integer.parseInt(textViewPriceC3.getText().toString())*Integer.parseInt(textViewPriceTotalC3.getText().toString()));
        if (Integer.parseInt(textViewQuantity.getText().toString()) <= 0 && Integer.parseInt(textViewQuantityc2.getText().toString())<=0 && Integer.parseInt(textViewQuantityc3.getText().toString())<=0) {
            Toast.makeText(getBaseContext(), "Invalid Quantity, please add an item.", Toast.LENGTH_LONG);
            Log.i("msg","Toast Message");

        } else{
            Intent intent = new Intent(this, CheckoutActivity.class);
            Bundle b =new Bundle();
            b.putString("Quantity",String.valueOf(total));
            Bundle bundle = new Bundle();
            bundle.putString("SubTotal",String.valueOf(subTotal));
            intent.putExtras(b);
            intent.putExtras(bundle);
            startActivity(intent);
}
    }
}

