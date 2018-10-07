package com.projects.mohammedsiddiq.carinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] carNames;
    private final int[] carImageIds;


    private Integer[] mThumbnailIds = {
            R.drawable.acura_body_kit_car_88628, R.drawable.asphalt_auto_automobile_244206,
            R.drawable.audi_automobile_car_lights_1149831, R.drawable.audi_sq5,
            R.drawable.benz_mercedess, R.drawable.wv_beetle_car_city_131811,
            R.drawable.ferrari_silverstone, R.drawable.range_rover,
            R.drawable.chevrolet_asphalt, R.drawable.lambhorgini, R.drawable.bmw_m6_coupe_automotive_beautiful_207600,
            R.drawable.jeep, R.drawable.chevrolet_bumper
    };


    public ImageAdapter(Context context, int[] carImages, String[] carNames) {
        mContext = context;
        this.carNames = carNames;
        this.carImageIds = carImages;

    }

    @Override
    public int getCount() {

        return mThumbnailIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        View carView;
//        GridItem gridItem = null;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            // if it's not recycled, initialize some attributes

//            carView = new View(mContext);
//            gridItem = new GridItem();

            carView = inflater.inflate(R.layout.cars_grid_layout, null);

//            carImage.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
//            carImage.setScaleType(ImageView.ScaleType.FIT_CENTER);


        } else {
            carView = (View) convertView;
        }
        TextView carName = (TextView) carView.findViewById(R.id.gridview_text);
        ImageView carImage = (ImageView) carView.findViewById(R.id.gridview_image);

//        gridItem.imageView = (ImageView) carView.findViewById(R.id.gridview_image);
//        gridItem.textView = (TextView) carView.findViewById(R.id.gridview_text);
        carImage.setPadding(5, 5, 5, 5);

        carImage.setImageResource(carImageIds[position]);
        carName.setText(carNames[position]);

//        imageView.setImageResource(mThumbnailIds[position]);
        return carView;
    }
//
//    static class GridItem {
//        TextView textView;
//        ImageView imageView;
//    }
}
