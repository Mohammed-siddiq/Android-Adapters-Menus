package com.projects.mohammedsiddiq.carinfo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CarImageView extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_image_view);
        final int websiteIndex = getIntent().getIntExtra(getResources().getString(R.string.viewPosition), 1);
        final int carIndex = getIntent().getIntExtra(getResources().getString(R.string.imageClicked), 1);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(carIndex);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setData(Uri.parse(getResources().getStringArray(R.array.websiteLinks)[websiteIndex]));
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);

            }
        });

    }
}
