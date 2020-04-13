package com.example.baitung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Restaurant> listrestaurant;

    public Adapter(Context context, int layout, ArrayList<Restaurant> listrestaurant) {
        this.context = context;
        this.layout = layout;
        this.listrestaurant = listrestaurant;
    }

    @Override
    public int getCount() {
        return listrestaurant.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(layout,null);
        TextView name=(TextView) convertView.findViewById(R.id.id_ten);
        TextView dc=(TextView) convertView.findViewById(R.id.textView5);
        TextView diem=(TextView) convertView.findViewById(R.id.id_diem);

        Restaurant restaurant=listrestaurant.get(position);
        name.setText(restaurant.getTen());
        dc.setText(restaurant.getDc());
        diem.setText(restaurant.getDiem()+"");

        return convertView;
    }
}
