package com.example.gametheme;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button re4, w3, bac, rdr2, er, st;
        re4 = findViewById(R.id.re4b);
        w3 = findViewById(R.id.w3b);
        bac = findViewById(R.id.bacb);
        rdr2 = findViewById(R.id.rdr2b);
        er = findViewById(R.id.erb);
        st = findViewById(R.id.stop);

        re4.setOnClickListener(this);
        w3.setOnClickListener(this);
        bac.setOnClickListener(this);
        rdr2.setOnClickListener(this);
        er.setOnClickListener(this);
        st.setOnClickListener(this);

        TextView re4t, rdr2t, bact, w3t, ert;
        re4t = findViewById(R.id.re4t);
        bact = findViewById(R.id.bact);
        rdr2t = findViewById(R.id.rdr2t);
        w3t = findViewById(R.id.w3t);
        ert = findViewById(R.id.ert);
    }

    @Override
    public void onClick(View view) {
        int clicked = view.getId();
        if(clicked == R.id.re4b){
            Play(R.raw.residentevil4);
        } else if(clicked == R.id.w3b){
            Play(R.raw.witcher3);
        }else if(clicked == R.id.bacb){
            Play(R.raw.arkhamcity);
        }else if(clicked == R.id.rdr2b){
            Play(R.raw.reddeadredemption2);
        }else if(clicked == R.id.erb){
            Play(R.raw.eldenring);
        }else if(clicked == R.id.stop){
            Stop();
        }
    }
    private MediaPlayer media;
    public void Play(int id){
        media = MediaPlayer.create(this, id);
        media.start();
    }
    public void Stop(){
        if (media != null) {
            if (media.isPlaying()) {
                media.stop();
            }
            media.release();
            media = null;  // Reset the media player
        }
    }
}