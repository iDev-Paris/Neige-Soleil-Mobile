package com.example.mysncf_jv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inscription extends AppCompatActivity implements View.OnClickListener {
    private TextView tvTitre ;
    private EditText txtNom, txtPrenom;
    private Button btParticiper ;
    private String rer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        this.tvTitre = (TextView) findViewById(R.id.idTitre);
        this.txtNom =(EditText) findViewById(R.id.idNom);
        this.txtPrenom = (EditText ) findViewById(R.id.idPrenom);
        this.btParticiper =(Button) findViewById(R.id.idParticiper);

        this.btParticiper.setOnClickListener(this);
        //on récupere le nom du rer
        this.rer = this.getIntent().getStringExtra("rer").toString();
        this.tvTitre.setText("Binevenue dans l'enquête du : " + this.rer);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idParticiper)
        {
            String nom = this.txtNom.getText().toString();
            String prenom = this.txtPrenom.getText().toString();

            //inscrire un candidat
            Candidat unCandidat = new Candidat(nom, prenom);
            //on ajoute cette instance dans l'enquete
            SNCF.getEnquete(this.rer).ajouterCandidat(unCandidat);

            //on passe à la première page
            Intent unIntent = new Intent(this, Page1.class);
            unIntent.putExtra("rer", this.rer);
            unIntent.putExtra("nom", nom);
            this.startActivity(unIntent);
        }
    }
}