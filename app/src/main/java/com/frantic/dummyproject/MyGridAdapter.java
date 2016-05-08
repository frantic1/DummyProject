package com.frantic.dummyproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Frantic on 2/20/2016.
 */
public class MyGridAdapter extends ArrayAdapter<Seats> {
    private Context context;
    private List<Seats> seatsList;
    private ImageView seatimage;

    public MyGridAdapter(Context context, int resource, List<Seats> objects) {
        super(context, resource, objects);
        this.context=context;
        this.seatsList=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.seat_item,parent,false);

        seatimage = (ImageView) v.findViewById(R.id.seat1);

        Seats seats = seatsList.get(position);
        if(seats.getSeat_status().equalsIgnoreCase("available")){

            seatimage.setImageResource(R.drawable.seat_avv);
        } if(seats.getSeat_status().equalsIgnoreCase("booked")){

            seatimage.setImageResource(R.drawable.seat_booked);
        }if(seats.getSeat_status().equalsIgnoreCase("unavailable")){

            seatimage.setImageResource(R.drawable.seat_unavailable);
        }

        return v;
    }
}
