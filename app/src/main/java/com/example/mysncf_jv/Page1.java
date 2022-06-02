package com.example.mysncf_jv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Page1 extends AppCompatActivity implements View.OnClickListener
{
    private RadioGroup rgInformation, rgPonctualite ;
    private Button btSuivant ;
    private String rer, nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        this.rgInformation = (RadioGroup) findViewById(R.id.idInformation);
        this.rgPonctualite =(RadioGroup) findViewById(R.id.idPonctualite);
        this.btSuivant = (Button) findViewById(R.id.idSuivant);
        this.rer = this.getIntent().getStringExtra("rer").toString();
        this.nom = this.getIntent().getStringExtra("nom").toString();
        this.btSuivant.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    if (v.getId()== R.id.idSuivant)
    {
        //on calcule le score

        int score = 0;
        switch (this.rgPonctualite.getCheckedRadioButtonId())
        {
            case R.id.idPonctualite1 : score = 20 ; break;
            case R.id.idPonctualite2 : score = 16; break;
            case R.id.idPonctualite3 : score = 8 ; break;
        }
        SNCF.getEnquete(this.rer).getCandidat(this.nom).ajouterReponse("ponctualite", score);

        switch (this.rgInformation.getCheckedRadioButtonId())
        {
            case R.id.idInformation1 : score = 20 ; break;
            case R.id.idInformation2 : score = 16; break;
            case R.id.idInformation3 : score = 8 ; break;
        }
        SNCF.getEnquete(this.rer).getCandidat(this.nom).ajouterReponse("information", score);


        //on passe à la deuxième page
        Intent unIntent = new Intent(this, Page2.class);
        unIntent.putExtra("rer", this.rer);
        unIntent.putExtra("nom", this.nom);
        this.startActivity(unIntent);
    }
    }
}