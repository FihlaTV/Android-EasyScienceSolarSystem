package com.example.matteo.easysciencesolarsystem;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ViewHolder>{

    //Create two array lists to hold planet names and images
    private ArrayList<String> mPlanetNames = new ArrayList<>();
    private ArrayList<String> mPlanetImages = new ArrayList<>();
    private Context mContext;

    public StaggeredRecyclerViewAdapter(ArrayList<String> mPlanetNames, ArrayList<String> mPlanetImages, Context mContext) {
        this.mPlanetNames = mPlanetNames;
        this.mPlanetImages = mPlanetImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                .asBitmap()
                .load(mPlanetImages.get(position))
                .into(holder.image);

        holder.planetName.setText(mPlanetNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mPlanetNames.get(position), Toast.LENGTH_SHORT).show();
                switch(mPlanetNames.get(position)){
                    case "Sun":  openSun();
                        break;
                    case "Mercury":  openMercury();
                        break;
                    case "Venus":  openVenus();
                        break;
                    case "Earth":  openEarth();
                        break;
                    case "Mars":  openMars();
                        break;
                    case "Jupiter":  openJupiter();
                        break;
                    case "Saturn":  openSaturn();
                        break;
                    case "Uranus":  openUranus();
                        break;
                    case "Neptune":  openNeptune();
                        break;
                    case "Pluto":  openPluto();
                        break;
                    default:
                        Toast.makeText(mContext, "No Planet selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openSun() {
        Intent intent = new Intent (mContext, Sun.class);
        mContext.startActivity(intent);
    }
    public void openMercury() {
        Intent intent2 = new Intent (mContext, Mercury.class);
        mContext.startActivity(intent2);
    }
    public void openVenus() {
        Intent intent3 = new Intent (mContext, Venus.class);
        mContext.startActivity(intent3);
    }
    public void openEarth() {
        Intent intent4 = new Intent (mContext, Earth.class);
        mContext.startActivity(intent4);
    }
    public void openMars() {
        Intent intent5 = new Intent (mContext, Mars.class);
        mContext.startActivity(intent5);
    }
    public void openJupiter() {
        Intent intent6 = new Intent (mContext, Jupiter.class);
        mContext.startActivity(intent6);
    }
    public void openSaturn() {
        Intent intent7 = new Intent (mContext, Saturn.class);
        mContext.startActivity(intent7);
    }
    public void openUranus() {
        Intent intent8 = new Intent (mContext, Uranus.class);
        mContext.startActivity(intent8);
    }
    public void openNeptune() {
        Intent intent9 = new Intent (mContext, Neptune.class);
        mContext.startActivity(intent9);
    }
    public void openPluto() {
        Intent intent10 = new Intent (mContext, Pluto.class);
        mContext.startActivity(intent10);
    }

    @Override
    public int getItemCount() {
        return mPlanetImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView planetName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.planet_image);
            planetName = itemView.findViewById(R.id.planet_name);
            parentLayout = itemView.findViewById(R.id.planet_layout);

        }
    }
}
