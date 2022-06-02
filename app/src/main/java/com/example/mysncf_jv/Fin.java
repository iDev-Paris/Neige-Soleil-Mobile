package com.example.mysncf_jv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Fin extends AppCompatActivity implements View.OnClickListener
{
    private TextView tvResultat;
    private ImageView imgSmiley;
    private Button btResultats ;
    private String rer, nom ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        this.tvResultat = (TextView) findViewById(R.id.idResultat);
        this.imgSmiley = (ImageView) findViewById(R.id.idSmiley);
        this.btResultats = (Button) findViewById(R.id.idLesResultats);
        this.btResultats.setOnClickListener(this);
        this.rer = this.getIntent().getStringExtra("rer").toString();
        this.nom = this.getIntent().getStringExtra("nom").toString();
        //calcul de la moyenne
        float moyen = SNCF.getEnquete(this.rer).getCandidat(this.nom).moyenne();
        this.tvResultat.setText("Votre résultat M. " +this.nom+" : "+moyen);

        if (moyen < 10){
            this.imgSmiley.setImageResource(R.drawable.smiley_3);
        }else if (moyen < 12 ){
            this.imgSmiley.setImageResource(R.drawable.smiley_2);
        } else {
            this.imgSmiley.setImageResource(R.drawable.smiley_1);
        }
    }

    @Override
    public void onClick(View v) {
    if (v.getId()==R.id.idLesResultats)
    {
        //on passe à la  page résultats
        Intent unIntent = new Intent(this, Resultats.class);
        unIntent.putExtra("rer", this.rer);
        this.startActivity(unIntent);
    }
    }
}