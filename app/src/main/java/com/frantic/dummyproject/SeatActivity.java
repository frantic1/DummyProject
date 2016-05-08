package com.frantic.dummyproject;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SeatActivity extends AppCompatActivity {

    List<Seats> seatsList;
    List<String> list;
    GridView mygrid;
    MyGridAdapter adapter;
    private ImageView seatimage;
    private Button done;
    private TextView seat_item,seat_price;
    String seatStatus,seat_no;
    int seat_pr,pr=0,counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);

        seatsList = new ArrayList<>();
        list = new ArrayList<>();
        initItems();

        done = (Button) findViewById(R.id.btn_nxt);

        mygrid = (GridView) findViewById(R.id.seat_grids);
        adapter = new MyGridAdapter(getApplicationContext(),R.layout.seat_item,seatsList);
        mygrid.setAdapter(adapter);
        mygrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Seats seats = seatsList.get(position);
                seatStatus = seats.getSeat_status();
                seat_no = seats.getSeat_no();
                seat_pr = (int) seats.getSeat_price();
                seatimage = (ImageView) view.findViewById(R.id.seat1);
                seat_item = (TextView) findViewById(R.id.labelSeat);
                seat_price = (TextView) findViewById(R.id.labelPrice);
                if (counter < 7) {


                    if (seatStatus.equalsIgnoreCase("available")) {
                        seatimage.setImageResource(R.drawable.seat);
                        seats.setSeat_status("selected");
                        pr += seat_pr;
                        Log.d("price", pr + "");
                        seat_price.setText("Rs " + Integer.toString(pr));
                        list.add(seat_no);
                        String s = TextUtils.join(",", list);
                        seat_item.setText(s);
                        counter++;
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Only 7 seats allowed", Toast.LENGTH_SHORT).show();
                }
                if (seatStatus.equalsIgnoreCase("selected")) {
                    seatimage.setImageResource(R.drawable.seat_avv);
                    seats.setSeat_status("available");
                    pr -= seat_pr;
                    Log.d("price", pr + "");
                    seat_price.setText("Rs " + Integer.toString(pr));

                    list.remove(seat_no);
                    String s = seat_item.getText().toString().trim();
                    s.replaceAll(s, "");
                    s = TextUtils.join(",", list);
                    seat_item.setText(s);
                    counter--;
                }


                Log.d("Total seats", seat_item.getText().toString().trim());
            }
        });



        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pr>20){
                    String a = seat_item.getText().toString().trim();
                    String b = Integer.toString(pr);
                    Intent intent = new Intent(getApplicationContext(), LabelActivity.class);
                    intent.putExtra("seat", a);
                    intent.putExtra("price", b);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Please Select Seats first",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public String operation(String a,String b){
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        a=sb.toString();

        return a;
    }

    public  void initItems(){
        seatsList.add(new Seats("A1","available",700));
        seatsList.add(new Seats("A2","available",700));
        seatsList.add(new Seats("B1","available",700));
        seatsList.add(new Seats("B2","available",700));
        seatsList.add(new Seats("A3","unavailable",700));
        seatsList.add(new Seats("A4","booked",700));
        seatsList.add(new Seats("A5","available",700));
        seatsList.add(new Seats("A6","available",700));
        seatsList.add(new Seats("A7","available",700));
        seatsList.add(new Seats("A8","available",700));
        seatsList.add(new Seats("A9","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A1","available",700));
        seatsList.add(new Seats("A2","available",700));
        seatsList.add(new Seats("B1","available",700));
        seatsList.add(new Seats("B2","available",700));
        seatsList.add(new Seats("A3","unavailable",700));
        seatsList.add(new Seats("A4","booked",700));
        seatsList.add(new Seats("A5","available",700));
        seatsList.add(new Seats("A6","available",700));
        seatsList.add(new Seats("A7","available",700));
        seatsList.add(new Seats("A8","available",700));
        seatsList.add(new Seats("A9","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A1","available",700));
        seatsList.add(new Seats("A2","available",700));
        seatsList.add(new Seats("B1","available",700));
        seatsList.add(new Seats("B2","available",700));
        seatsList.add(new Seats("A3","unavailable",700));
        seatsList.add(new Seats("A4","booked",700));
        seatsList.add(new Seats("A5","available",700));
        seatsList.add(new Seats("A6","available",700));
        seatsList.add(new Seats("A7","available",700));
        seatsList.add(new Seats("A8","available",700));
        seatsList.add(new Seats("A9","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));
        seatsList.add(new Seats("A10","available",700));


    }
}
