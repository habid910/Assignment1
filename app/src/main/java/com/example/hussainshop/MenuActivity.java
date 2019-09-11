package com.example.hussainshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    int card1Count=0;
    int card2Count=0;
    int card3Count=0;

    TextView textViewQuantity;
    TextView textViewQuantityc2;
    TextView getTextViewQuantityc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        textViewQuantity =(TextView)findViewById(R.id.textViewQuantity);
        textViewQuantityc2 = findViewById(R.id.textViewQuantityc2);
        getTextViewQuantityc3 = findViewById(R.id.textViewQuantityc3);
    }

    public void addQuantity(View view) {
        card1Count++;
        if(textViewQuantity!=null)
            textViewQuantity.setText(Integer.toString(card1Count));

    }

    public void subtractQuantity(View view) {
       /* if(Integer.parseInt(textViewQuantity.getText().toString())<0){
            Toast.makeText(this,"Invalid Quantity, please add an item.",Toast.LENGTH_SHORT);

        }*/
       --card1Count;
        if(textViewQuantity!=null ){
            textViewQuantity.setText(Integer.toString(card1Count));
        }
    }

    public void addQuantityc2(View view) {
        ++card2Count;
        if(textViewQuantityc2!=null)
            textViewQuantityc2.setText(Integer.toString(card2Count));
    }
    public void subtractQuantityc2(View view) {
        --card2Count;
        if(textViewQuantityc2!=null)
            textViewQuantityc2.setText(Integer.toString(card2Count));
    }
    public void subtractQuantityC3(View view) {
        --card3Count;
        if(getTextViewQuantityc3!=null)
            getTextViewQuantityc3.setText(Integer.toString(card3Count));
    }

    public void addQuantityC3(View view) {
        card3Count++;
        if(getTextViewQuantityc3!=null)
            getTextViewQuantityc3.setText(Integer.toString(card3Count));
    }


}
