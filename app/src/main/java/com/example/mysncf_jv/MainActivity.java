package com.example.mysncf_jv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private ImageButton imgRerA, imgRerB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.imgRerA=(ImageButton) findViewById(R.id.idRerA);
        this.imgRerB=(ImageButton) findViewById(R.id.idRerB);

        this.imgRerA.setOnClickListener(this);
        this.imgRerB.setOnClickListener(this);

        //initialisation des enquetes
        SNCF.initialiser();
    }

    @Override
    public void onClick(View v) {
        String rer ="";
        switch(v.getId())
        {
            case R.id.idRerA : rer = "RERA"; break;
            case R.id.idRerB : rer = "RERB"; break;
        }
        //on passe à la page suivante d'inscription
        Intent unIntent = new Intent(this, Inscription.class);
        unIntent.putExtra("rer", rer);
        this.startActivity(unIntent);
    }
}