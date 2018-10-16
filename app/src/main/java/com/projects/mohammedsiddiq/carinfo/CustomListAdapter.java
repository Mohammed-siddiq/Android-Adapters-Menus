package com.projects.mohammedsiddiq.carinfo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {
    private final Context context;
    private final String[] namesAndAddressess;
    private int carIndex;


    public CustomListAdapter(Context context, String[] namesAndAddressess, int carIndex) {
        this.context = context;
        this.namesAndAddressess = namesAndAddressess;
        this.carIndex = carIndex;

    }

    @Override
    public int getCount() {
        return namesAndAddressess.length;
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

        Log.d("custom adapter", "Inside custom adapter ");
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView;
        if(convertView == null)
        {
             rowView = inflater.inflate(R.layout.car_dealer, null, true);
        }
        else {
            rowView = convertView;
        }
        //this code gets references to objects in the car dealers xml file
        TextView dealerName = (TextView) rowView.findViewById(R.id.carDealerName);
        TextView dealerAddress = (TextView) rowView.findViewById(R.id.carDealerAddress);
        Log.d("custom Adapter", "Position clicked " + carIndex) ;
        //this code sets the values of the objects to values from the arrays
        dealerName.setText(namesAndAddressess[position].split(":")[0]);
        dealerAddress.setText(namesAndAddressess[position].split(":")[1]);
//        imageView.setImageResource(imageIDarray[position]);

        Log.d("Custom adapter", "Values set");

        return rowView;


    }
}
