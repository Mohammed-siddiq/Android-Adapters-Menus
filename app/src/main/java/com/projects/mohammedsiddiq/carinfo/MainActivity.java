package com.projects.mohammedsiddiq.carinfo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {


    private int[] carIds = {
            R.drawable.acura_body_kit_car_88628, R.drawable.asphalt_auto_automobile_244206,
            R.drawable.audi_automobile_car_lights_1149831, R.drawable.audi_sq5,
            R.drawable.benz_mercedess, R.drawable.wv_beetle_car_city_131811,
            R.drawable.ferrari_silverstone, R.drawable.range_rover,
            R.drawable.chevrolet_asphalt, R.drawable.lambhorgini, R.drawable.bmw_m6_coupe_automotive_beautiful_207600,
            R.drawable.jeep, R.drawable.chevrolet_bumper
    };

    private String mcarNames[];
    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Todo
            // A short click brings up a new activity that shows the entire picture of the selected car on the entire device display.
            // This picture must be a higher resolution and bigger than the thumbnail displayed earlier

            Toast.makeText(MainActivity.this, "Car name " + mcarNames[position], Toast.LENGTH_LONG).show();

            Intent intent = new Intent(MainActivity.this, CarImageView.class);
            intent.putExtra(getResources().getString(R.string.viewPosition), position);
            intent.putExtra(getResources().getString(R.string.imageClicked), carIds[position]);
            startActivity(intent);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcarNames = getResources().getStringArray(R.array.CarNames);
        GridView carView = (GridView) findViewById(R.id.carGridView);
        carView.setAdapter(new ImageAdapter(this, carIds, mcarNames));

        carView.setOnItemClickListener(itemClickListener);

//        carView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // Todo
//                // A short click brings up a new activity that shows the entire picture of the selected car on the entire device display.
//                // This picture must be a higher resolution and bigger than the thumbnail displayed earlier
//
//                Toast.makeText(MainActivity.this, "Car name " + mcarNames[position], Toast.LENGTH_LONG).show();
//
//                Intent intent = new Intent(MainActivity.this,CarImageView.class);
//                intent.putExtra(getResources().getString(R.string.viewPosition),position);
//                intent.putExtra(getResources().getString(R.string.imageClicked), carIds[position]);
//                startActivity(intent);
//
//            }
//        });
        registerForContextMenu(carView);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.cars_context, menu);
    }

/*
 A long click on a grid cell brings up a “context menu” showing the following three options for the car under consideration:
 (1) View the entire picture (similar to a short click);
 (2) Show the official web page of the car manufacturer in a new activity; and
 (3) bring up a list view containing the names and addresses of at least three car dealers for the selected manufacturer in greater Chicago area.
*/


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.viewPicture:
                viewPicture(info.position);
                return true;
            case R.id.openWebPage:
                openWebpage(info.position);
                return true;
            case R.id.showCarDealers:
                showCarDealers(info.position,mcarNames[info.position]);

            default:
                return super.onContextItemSelected(item);
        }
    }

    private void showCarDealers(int position,String carName) {
        Intent intent = new Intent(MainActivity.this,CarDealers.class);
        intent.putExtra(String.valueOf(R.string.imageClicked),position);
        intent.putExtra(String.valueOf(R.string.carName),carName);
        startActivity(intent);

    }

    //opens web page
    private void openWebpage(int position) {
        Intent intent = new Intent();
        intent.setData(Uri.parse(getResources().getStringArray(R.array.websiteLinks)[position]));
        intent.setAction(Intent.ACTION_VIEW);
        startActivity(intent);
    }


    //Displays picture in new activity
    private void viewPicture(int position) {
        Intent intent = new Intent(MainActivity.this, CarImageView.class);
        intent.putExtra(getResources().getString(R.string.viewPosition), position);
        intent.putExtra(getResources().getString(R.string.imageClicked), carIds[position]);
        startActivity(intent);

    }
}
