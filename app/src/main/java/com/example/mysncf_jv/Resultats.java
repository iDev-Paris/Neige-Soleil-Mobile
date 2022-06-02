package com.example.mysncf_jv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Resultats extends AppCompatActivity implements View.OnClickListener
{
    private ListView lvResultats ;
    private Button btRetour;
    private String rer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);
        this.lvResultats=(ListView) findViewById(R.id.idListe);
        this.btRetour = (Button) findViewById(R.id.idRetour);
        this.btRetour.setOnClickListener(this);

        this.rer = this.getIntent().getStringExtra("rer").toString();
        //extraction des resultats d'un rer et présentation de ses resultats dans
        //la liste view

        ArrayAdapter unAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                SNCF.getEnquete(this.rer).getResultats());
        this.lvResultats.setAdapter(unAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idRetour)
        {
            Intent unIntent = new Intent(this, MainActivity.class);
            this.startActivity(unIntent);
        }
    }
}