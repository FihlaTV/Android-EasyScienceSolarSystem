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
                    case "Sun":  openPlanet();
                        break;
                    case "Mercury":  openPlanet();
                        break;
                    case "Venus":  openPlanet();
                        break;
                    case "Earth":  openPlanet();
                        break;
                    case "Mars":  openPlanet();
                        break;
                    case "Jupiter":  openPlanet();
                        break;
                    case "Saturn":  openPlanet();
                        break;
                    case "Uranus":  openPlanet();
                        break;
                    case "Neptune":  openPlanet();
                        break;
                    case "Pluto":  openPlanet();
                        break;
                    default:
                        Toast.makeText(mContext, "No Planet selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void openPlanet() {
        Intent intent = new Intent (mContext, Planet.class);
        mContext.startActivity(intent);
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
