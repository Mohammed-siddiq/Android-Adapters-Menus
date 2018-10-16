package com.projects.mohammedsiddiq.carinfo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class CarDealers extends Activity {

    private TypedArray typedArray;
    private String nameAndAddresses[][] ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_dealers_list);
        Intent intent = getIntent();
        int indexOfImage = intent.getIntExtra(String.valueOf(R.string.imageClicked),1);
        String carName = intent.getStringExtra(String.valueOf(R.string.carName));
        typedArray = getResources().obtainTypedArray(R.array.carDealers); // Reading the name and addresses from the string resources
        loadNamesAndAddress(typedArray); // storing as arrays of strings
        TextView textView = findViewById(R.id.dealerHeading);
        textView.setText(textView.getText() + " " + carName);
        ListView listView = (ListView)findViewById(R.id.dealersList);
        CustomListAdapter listAdapter = new CustomListAdapter(this,nameAndAddresses[indexOfImage],indexOfImage);
        listView.setAdapter(listAdapter);


    }

    public void loadNamesAndAddress(TypedArray nameAndAddressesTA) {
        Resources resources = getResources();
        nameAndAddresses = new String[nameAndAddressesTA.length()][];
        for (int i = 0; i < nameAndAddressesTA.length(); i++) {
            int id = nameAndAddressesTA.getResourceId(i,0);
            if(id>0)
            {
                nameAndAddresses[i] = resources.getStringArray(id);
            }
        }
    }
}
