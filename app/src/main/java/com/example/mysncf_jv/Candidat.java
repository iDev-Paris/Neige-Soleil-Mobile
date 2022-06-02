package com.example.mysncf_jv;

import java.util.HashMap;

public class Candidat
{
    private String nom, prenom;
    private HashMap<String, Integer> lesReponses ;

    public Candidat(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.lesReponses = new HashMap<>();
    }
    public void ajouterReponse (String question, int score)
    {
        this.lesReponses.put (question, score);
    }

    public float moyenne ()
    {
        float moy = 0;
        for (Integer score : this.lesReponses.values())
        {
            moy += score;
        }
        return (moy / this.lesReponses.size());
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public HashMap<String, Integer> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(HashMap<String, Integer> lesReponses) {
        this.lesReponses = lesReponses;
    }
}
