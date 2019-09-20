package com.example.hussainshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DecimalFormat currency = new DecimalFormat("###,###.##");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Bundle b = getIntent().getExtras();
        String data = b.getString("Quantity");
        TextView totalQty = findViewById(R.id.totalQuantity);
        totalQty.setText(data);
        String subTotalDadata = b.getString("SubTotal");
        TextView subTotal = findViewById(R.id.textViewSubTotalAmount);
        subTotal.setText(subTotalDadata);
        TextView gst = findViewById(R.id.textViewGSTAmount);
        double totalGST = 0.05 * Double.parseDouble(subTotal.getText().toString());
        String totals = String.valueOf(currency.format(totalGST));
        gst.setText(totals);
        TextView tvq = findViewById(R.id.textViewTVQAmount);
        double totalTVQ = 0.09975 * Double.parseDouble(subTotal.getText().toString());
        String totalTVQAmount = String.valueOf(currency.format(totalTVQ));
        tvq.setText(totalTVQAmount);
        TextView totalAmount = findViewById(R.id.textViewTotalAmount);

        double totalAmounts = totalGST + totalTVQ + Double.parseDouble(subTotal.getText().toString());

        String finalTotal = String.valueOf(currency.format(totalAmounts));

        totalAmount.setText(finalTotal);
    }
}
