package com.example.mysncf_jv;

import java.util.ArrayList;
import java.util.HashMap;

public class Enquete2 {
    private HashMap<String, Candidat> lesCandidats;

    public Enquete2(){
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
        for (Candidat unCandidat2 : this.lesCandidats.values())
        {
            lesResultats.add(unCandidat2.getNom() + "  " +unCandidat2.getPrenom()
                       + "  " + unCandidat2.moyenne());
        }
        return lesResultats;
    }
}
