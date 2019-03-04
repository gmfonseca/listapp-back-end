package com.groupoffive.listapp.util;

import info.debatty.java.stringsimilarity.NormalizedLevenshtein;

public class Levenshtein {

    /**
     * Devolve a relevância de duas Strings passadas por parâmetro
     * @param s1
     * @param s2
     * @return
     */
    public static Double stringsDistance(String s1, String s2) {
        NormalizedLevenshtein l = new NormalizedLevenshtein();
        Double distancia        = l.distance(s1, s2);

        /* Caso uma das strings contenha a outra, remover 0,1*t de distância */
        if (s1.toLowerCase().contains(s2.toLowerCase()) ||
                s2.toLowerCase().contains(s1.toLowerCase())) {
            distancia -= s1.length() * 0.1d;
        }

        /* Caso a segunda string comece com a primeira, remover 0,05*t de distância */
        if (s2.toLowerCase().startsWith(s1.toLowerCase())) {
            distancia -= s1.length() * 0.05d;
        }

        return distancia;
    }

}
