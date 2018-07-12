package com.devzone.matthausen.easysciencesolarsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrl = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
        ImageView sun = findViewById(R.id.sun);
        ImageView mercury = findViewById(R.id.mercury);
        ImageView venus = findViewById(R.id.venus);
        ImageView earth = findViewById(R.id.earth);
        ImageView mars = findViewById(R.id.mars);
        ImageView jupiter = findViewById(R.id.jupiter);
        ImageView saturn = findViewById(R.id.saturn);
        ImageView uranus = findViewById(R.id.uranus);
        ImageView neptune = findViewById(R.id.neptune);
        ImageView pluto = findViewById(R.id.pluto);
        sun.setTag(1);
        mercury.setTag(2);
        venus.setTag(3);
        earth.setTag(4);
        mars.setTag(5);
        jupiter.setTag(6);
        saturn.setTag(7);
        uranus.setTag(8);
        neptune.setTag(9);
        pluto.setTag(10);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGame();
            }
        };
        sun.setOnClickListener(onClickListener);
        mercury.setOnClickListener(onClickListener);
        venus.setOnClickListener(onClickListener);
        earth.setOnClickListener(onClickListener);
        mars.setOnClickListener(onClickListener);
        jupiter.setOnClickListener(onClickListener);
        saturn.setOnClickListener(onClickListener);
        uranus.setOnClickListener(onClickListener);
        neptune.setOnClickListener(onClickListener);
        pluto.setOnClickListener(onClickListener);
        initImageBitmaps();
    }

    public void openGame(){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }


    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: initializing bitmaps");

        mImageUrl.add("http://racjonalista.tv/wp-content/uploads/2015/03/eit_19970914_0121_304.gif");
        mNames.add("Sun");

        mImageUrl.add("https://cdn.images.express.co.uk/img/dynamic/151/590x/secondary/mercury-1262214.jpg");
        mNames.add("Mercury");

        mImageUrl.add("https://c1.staticflickr.com/5/4704/24771639777_c053614594_b.jpg");
        mNames.add("Venus");

        mImageUrl.add("https://cdn.britannica.com/700x450/25/160325-004-AD594C66.jpg");
        mNames.add("Earth");

        mImageUrl.add("https://upload.wikimedia.org/wikipedia/commons/0/02/OSIRIS_Mars_true_color.jpg");
        mNames.add("Mars");

        mImageUrl.add("https://www.nasa.gov/sites/default/files/jupiter_1_0.jpg");
        mNames.add("Jupiter");

        mImageUrl.add("http://www.astronomy.com/-/media/Images/News%20and%20Observing/News/2017/09/saturn.png?mw=600");
        mNames.add("Saturn");

        mImageUrl.add("https://upload.wikimedia.org/wikipedia/commons/3/3d/Uranus2.jpg");
        mNames.add("Uranus");

        mImageUrl.add("http://sen.com/thumbs/1024x576/img/143231738831751432318281.jpg");
        mNames.add("Neptune");

        mImageUrl.add("https://img.purch.com/w/660/aHR0cDovL3d3dy5zcGFjZS5jb20vaW1hZ2VzL2kvMDAwLzA0OC85OTkvb3JpZ2luYWwvcGx1dG8tbmV3LWhvcml6b25zLWp1bHktMjAxNS5qcGc=");
        mNames.add("Pluto");

        initRecycleView();

    }

    private void initRecycleView(){
        Log.d(TAG, "initRecycleView: initialize recyclerView");

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter =
                new StaggeredRecyclerViewAdapter(mNames, mImageUrl, this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdapter);
    }
}
