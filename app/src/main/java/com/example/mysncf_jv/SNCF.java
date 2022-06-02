package com.example.mysncf_jv;

import java.util.HashMap;

public class SNCF
{
    private static HashMap<String, Enquete> lesEnquetes = new HashMap<>();
    //cle : nom du rer
    //valeur : une instance de la classe Enquete

    public static void initialiser()
    {
        if ( ! lesEnquetes.containsKey("RERA")) {
            lesEnquetes.put("RERA", new Enquete());
        }
        if ( ! lesEnquetes.containsKey("RERB")) {
            lesEnquetes.put("RERB", new Enquete());
        }
    }
    public static Enquete getEnquete (String rer){
        return lesEnquetes.get(rer);
    }
}
