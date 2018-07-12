package com.example.matteo.easysciencesolarsystem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.sql.Time;

public class Game extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "Game";

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        Log.d(TAG, "onCreate: started");

        Spinner spinner = findViewById(R.id.planets_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(final AdapterView<?> adapterView, View view, final int i, long l) {

        try {
            Button btn = findViewById(R.id.button);
            final TextView weighMe = findViewById(R.id.weighMe);
            final TextView lightSpeed = findViewById(R.id.lightSpeed);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        EditText weight = findViewById(R.id.user_weight);
                        String strWeight = weight.getText().toString();
                        Double dblWeight = Double.parseDouble(strWeight);

                        Double pGravity = 0.0;
                        String strGravity = "";

                        Double Gravity = 0.0;
                        String Time = "";

                        switch (adapterView.getItemAtPosition(i).toString()) {
                            case "Sun":
                                Gravity = 27.07;
                                Time = "8.3 min";
                                pGravity = (dblWeight * Gravity);
                                strGravity = String.valueOf(Math.round(pGravity));
                                weighMe.setText("Your weight: " + strGravity + " kg");
                                lightSpeed.setText("Travel time: " + Time);
                                break;
                            case "Mercury":
                                Gravity = 0.38;
                                Time = "5.1 min";
                                pGravity = (dblWeight * Gravity);
                                strGravity = String.valueOf(Math.round(pGravity));
                                weighMe.setText("Your weight: " + strGravity + " kg");
                                lightSpeed.setText("Travel time: " + Time);
                                break;
                            case "Venus":
                                Gravity = 0.90;
                                Time = "2.3 min";
                                pGravity = (dblWeight * Gravity);
                                strGravity = String.valueOf(Math.round(pGravity));
                                weighMe.setText("Your weight: " + strGravity + " kg");
                                lightSpeed.setText("Travel time: " + Time);
                                break;
                            case "Moon":
                                Gravity = 0.16;
                                Time = "1.3 sec";
                                pGravity = (dblWeight * Gravity);
                                strGravity = String.valueOf(Math.round(pGravity));
                                weighMe.setText("Your weight: " + strGravity + " kg");
                                lightSpeed.setText("Travel time: " + Time);
                                break;
                            case "Mars":
                                Gravity = 0.37;
                                Time = "4.3 min";
                                pGravity = (dblWeight * Gravity);
                                strGravity = String.valueOf(Math.round(pGravity));
                                weighMe.setText("Your weight: " + strGravity + " kg");
                                lightSpeed.setText("Travel time: " + Time);
                                break;
                            case "Jupiter":
                                Gravity = 2.52;
                                Time = "34.9 min";
                                pGravity = (dblWeight * Gravity);
                                strGravity = String.valueOf(Math.round(pGravity));
                                weighMe.setText("Your weight: " + strGravity + " kg");
                                lightSpeed.setText("Travel time: " + Time);
                                break;
                            case "Saturn":
                                Gravity = 1.06;
                                Time = "1h 11min";
                                pGravity = (dblWeight * Gravity);
                                strGravity = String.valueOf(Math.round(pGravity));
                                weighMe.setText("Your weight: " + strGravity + " kg");
                                lightSpeed.setText("Travel time: " + Time);
                                break;
                            case "Uranus":
                                Gravity = 0.88;
                                Time = "2h 31min";
                                pGravity = (dblWeight * Gravity);
                                strGravity = String.valueOf(Math.round(pGravity));
                                weighMe.setText("Your weight: " + strGravity + " kg");
                                lightSpeed.setText("Travel time: " + Time);
                                break;
                            case "Neptune":
                                Gravity = 1.12;
                                Time = "4.1h";
                                pGravity = (dblWeight * Gravity);
                                strGravity = String.valueOf(Math.round(pGravity));
                                weighMe.setText("Your weight: " + strGravity + " kg");
                                lightSpeed.setText("Travel time: " + Time);
                                break;
                            case "Pluto":
                                Gravity = 0.06;
                                Time = "5.5h";
                                pGravity = (dblWeight * Gravity);
                                strGravity = String.valueOf(Math.round(pGravity));
                                weighMe.setText("Your weight: " + strGravity + " kg");
                                lightSpeed.setText("Travel time: " + Time);
                                break;
                            default:
                                break;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(Game.this, "Insert your weight in Kg", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Select a Planet" +
                "", Toast.LENGTH_SHORT).show();
    }
}
