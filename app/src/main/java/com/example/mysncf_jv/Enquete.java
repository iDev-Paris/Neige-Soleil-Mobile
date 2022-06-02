package com.example.mysncf_jv;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Enquete {
    private HashMap<String, Candidat> lesCandidats ;

    public Enquete(){
        this.lesCandidats = new HashMap<>();
    }
    public void ajouterCandidat (Candidat unCandidat)
    {
        this.lesCandidats.put(unCandidat.getNom(), unCandidat);
    }
    public Candidat getCandidat (String nom)
    {
        return this.lesCandidats.get(nom);
    }
    public ArrayList<String> getResultats ()
    {
        ArrayList<String> lesResultats = new ArrayList<>();
        for (Candidat unCandidat : this.lesCandidats.values())
        {
            lesResultats.add(unCandidat.getNom() + "  " +unCandidat.getPrenom()
                       + "  " + unCandidat.moyenne());
        }
        return lesResultats;
    }
}
