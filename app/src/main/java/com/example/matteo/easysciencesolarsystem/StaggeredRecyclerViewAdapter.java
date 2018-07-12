package com.example.matteo.easysciencesolarsystem;

import android.app.Activity;
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

                Intent intent = new Intent (mContext, Planet.class);
                intent.putExtra("image_url", mPlanetImages.get(position));
                switch(mPlanetNames.get(position)){
                    case "Sun": intent.putExtra("image_name", "Sun\n\nAvg Temperature: 5500°C / 9940°F\nStatus: Plasma\nComposition: Hydrogen, Helium\nDistance from Earth: 149 mln km / 93mln miles");
                                break;
                    case "Mercury": intent.putExtra("image_name", "Mercury\n\nAvg Temperature: 430°C / 800°F\nStatus: Solid\nComposition: Iron, Rocks\nDistance from Sun: 58 mln km / 36 mln miles");
                                break;
                    case "Venus": intent.putExtra("image_name", "Venus\n\nAvg Temperature: 462°C / 864°F\nStatus: Solid\nComposition: Earth-like rocks\nDistance from Sun: 108 mln km / 67 mln miles");
                                break;
                    case "Earth": intent.putExtra("image_name", "Earth\n\nAvg Temperature: 15°C / 58°F\nStatus: Solid\nComposition: Silicate rock, Magnesium, Iron\nDistance from Sun: 149 mln km / 93 mln miles\nMoons: 1");
                                break;
                    case "Mars": intent.putExtra("image_name", "Mars\n\nAvg Temperature: -55°C / -67°F\nStatus: Solid\nComposition: Oxidized Iron\nDistance from Sun: 228 mln km / 141 mln miles\nMoons: 2");
                                break;
                    case "Jupiter": intent.putExtra("image_name", "Jupiter\n\nAvg Temperature: -145°C / -234°F\nStatus: Gas\nComposition: Hydrogen, Helium\nDistance from Sun: 778 mln km / 484 mln miles\nMoons: 67");
                                break;
                    case "Saturn": intent.putExtra("image_name", "Saturn\n\nAvg Temperature: -178°C / -288°F\nStatus: Gas\nComposition: Hydrogen, Helium, Ammonia\nDistance from Sun: 1.4 bln km / 0.89 bln miles\nMoons: 62");
                                break;
                    case "Uranus": intent.putExtra("image_name", "Uranus\n\nAvg Temperature: -216°C / -357°F\nStatus: Gas\nComposition: Hydrogen, Helium, Methane\nDistance from Sun: 2.8 bln km / 1.7 bln miles\n Moons: 27");
                                break;
                    case "Neptune": intent.putExtra("image_name", "Neptune\n\nAvg Temperature: -214°C / -353°F\nStatus: Gas\nComposition: Hydrogen, Helium, Methane\nDistance from Sun: 4.5 bln km / 2.8 bln miles\n Moons: 14");
                                break;
                    case "Pluto": intent.putExtra("image_name", "Pluto\n\nAvg Temperature: -229°C / -380°F\nStatus: Solid\nComposition: Rocks, Water Ice\nDistance from Sun: 3.7 bln km / 2.3 bln miles\n Moons: 5");
                                break;
                    default: intent.putExtra("image_name", "This planet was not found");
                                break;
                }
                mContext.startActivity(intent);
            }
        });
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
