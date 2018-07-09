package com.example.matteo.easysciencesolarsystem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Planet extends AppCompatActivity{
    private static final String TAG = "Planet";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet_single);
        Log.d(TAG, "onCreate: started");
    }

    private void getIncomingIntent(){
        //First check if extras exists
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIncomingIntent: Found intent");
            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");

            setImage(imageUrl, imageName);

        }
    }
    
    private void setImage(String image_url, String imageName){
        Log.d(TAG, "setImage: setting image and name to widgets");
        TextView name = findViewById(R.id.full_description);
        name.setText(imageName);

        ImageView image = findViewById(R.id.image_large);
        Glide.with(this)
                .asBitmap()
                .load(image_url)
                .into(image);
    }
}
