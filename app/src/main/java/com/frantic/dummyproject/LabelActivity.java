package com.frantic.dummyproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LabelActivity extends AppCompatActivity {
    private TextView seat,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label);

        seat= (TextView) findViewById(R.id.seats);
        price= (TextView) findViewById(R.id.prices);
        Bundle bundle = getIntent().getExtras();
        seat.setText("Seats: "+bundle.getString("seat"));
        price.setText("Price: Rs "+bundle.getString("price"));
    }
}
