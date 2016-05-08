package com.frantic.swiperefresh;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Frantic on 4/20/2016.
 */
public class SwipeAdapter extends ArrayAdapter<Movie> {
    List<Movie> movieList;
    Context context;
    private String[] bgcolors;
    LayoutInflater inflater;

    public SwipeAdapter(Context context,int res, List<Movie> objects) {
        super(context,res,objects);
        this.context = context;
        this.movieList = objects;
        bgcolors = context.getApplicationContext().getResources().getStringArray(R.array.movie_serial_bg);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, parent,false);

        TextView serial = (TextView) convertView.findViewById(R.id.serial);
        TextView title = (TextView) convertView.findViewById(R.id.title);

        serial.setText(String.valueOf(movieList.get(position).id));
        title.setText(movieList.get(position).title);

        String color = bgcolors[position % bgcolors.length];
        serial.setBackgroundColor(Color.parseColor(color));

        return convertView;
    }
}
