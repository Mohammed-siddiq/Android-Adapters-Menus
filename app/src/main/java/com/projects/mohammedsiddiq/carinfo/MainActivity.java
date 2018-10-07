package com.projects.mohammedsiddiq.carinfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {



    private int[] mThumbnailIds = {
            R.drawable.acura_body_kit_car_88628, R.drawable.asphalt_auto_automobile_244206,
            R.drawable.audi_automobile_car_lights_1149831, R.drawable.audi_sq5,
            R.drawable.benz_mercedess, R.drawable.wv_beetle_car_city_131811,
            R.drawable.ferrari_silverstone, R.drawable.range_rover,
            R.drawable.chevrolet_asphalt, R.drawable.lambhorgini, R.drawable.bmw_m6_coupe_automotive_beautiful_207600,
            R.drawable.jeep, R.drawable.chevrolet_bumper
    };

    private  String mcarNames [] ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcarNames = getResources().getStringArray(R.array.CarNames);
        GridView carView = (GridView) findViewById(R.id.carGridView);
        carView.setAdapter(new ImageAdapter(this,mThumbnailIds,mcarNames));

        carView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Todo
                // A short click brings up a new activity that shows the entire picture of the selected car on the entire device display.
                // This picture must be a higher resolution and bigger than the thumbnail displayed earlier

                Toast.makeText(MainActivity.this, "Car name " + mcarNames[position], Toast.LENGTH_LONG).show();
            }
        });

    }
}
