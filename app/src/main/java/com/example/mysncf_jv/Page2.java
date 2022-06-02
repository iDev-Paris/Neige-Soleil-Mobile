package com.example.mysncf_jv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;


public class Page2 extends AppCompatActivity implements View.OnClickListener
{
    private RadioGroup rgService;
    private RatingBar rgProprete;
    private SeekBar rgSeekBar;
    private Button btTerminer;
    private String rer, nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        this.rgService = (RadioGroup) findViewById(R.id.idService);
        this.rgProprete =(RatingBar) findViewById(R.id.idProprete);
        this.rgSeekBar =(SeekBar) findViewById(R.id.idSeekBar);
        this.btTerminer = (Button) findViewById(R.id.idTerminer);
        this.rer = this.getIntent().getStringExtra("rer").toString();
        this.nom = this.getIntent().getStringExtra("nom").toString();
        this.btTerminer.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.idTerminer)
        {
            //on calcule le score
            int score = 0;

            switch (this.rgService.getCheckedRadioButtonId())
            {
                case R.id.idService1 : score = 20 ; break;
                case R.id.idService : score = 16; break;
                case R.id.idService3 : score = 8 ; break;
            }
            SNCF.getEnquete(this.rer).getCandidat(this.nom).ajouterReponse("service", score);

            if(rgProprete.getRating()==0)
            {
                score = 0;
            }
            else if(rgProprete.getRating()==0.5)
            {
                score = 2;
            }
            else if(rgProprete.getRating()==1)
            {
                score = 4;
            }
            else if(rgProprete.getRating()==1.5)
            {
                score = 6;
            }
            else if(rgProprete.getRating()==2)
            {
                score = 8;
            }
            else if(rgProprete.getRating()==2.5)
            {
                score = 10;
            }
            else if(rgProprete.getRating()==3)
            {
                score = 12;
            }
            else if(rgProprete.getRating()==3.5)
            {
                score = 14;
            }
            else if(rgProprete.getRating()==4)
            {
                score = 16;
            }
            else if(rgProprete.getRating()==4.5)
            {
                score = 18;
            }
            else if(rgProprete.getRating()==5)
            {
                score = 20;
            }
            SNCF.getEnquete(this.rer).getCandidat(this.nom).ajouterReponse("proprete", score);

            if(rgSeekBar.getProgress()==0)
            {
                score = 8;
            }

            else if(rgSeekBar.getProgress()==1)
            {
                score = 10;
            }

            else if(rgSeekBar.getProgress()==2)
            {
                score = 12;
            }

            else if(rgSeekBar.getProgress()==3)
            {
                score = 14;
            }

            else if(rgSeekBar.getProgress()==4)
            {
                score = 16;
            }

            else if(rgSeekBar.getProgress()==5)
            {
                score = 20;
            }
            SNCF.getEnquete(this.rer).getCandidat(this.nom).ajouterReponse("caca", score);


            //on passe à la deuxième page
            Intent unIntent = new Intent(this, Fin.class);
            unIntent.putExtra("rer", this.rer);
            unIntent.putExtra("nom", this.nom);
            this.startActivity(unIntent);
        }
    }
}