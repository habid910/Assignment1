package com.example.hussainshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Bundle b = getIntent().getExtras();
        String data= b.getString("Quantity");
        TextView totalQty = findViewById(R.id.totalQuantity);
        totalQty.setText(data);
        String subTotalDadata = b.getString("SubTotal");
        TextView subTotal = findViewById(R.id.textViewSubTotalAmount);
        subTotal.setText(subTotalDadata);
    }
}
