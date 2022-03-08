package com.asmar.webprog.datastrukturer.demo;

import java.util.*;

public class Datastrukturer {
    public static void main(String[] args) {
        System.out.println("Datastrukturer");

        // statisk datatype
        int [] array = {2,5,21,1,7,8};

        // dynamisk datatype
        List<Integer> enkelListe = new ArrayList<>();
        enkelListe.add(2);
        enkelListe.add(5);
        List<Integer> enkelListe2 = new ArrayList<>(Arrays.asList(2,3,7,5,8));
        System.out.println(enkelListe2);

        List<Integer> sammenkjedetListe = new LinkedList<>();
        sammenkjedetListe.add(2);

        List<Integer> stakk = new Stack<>();
        stakk.add(2);
        stakk.add(4);
        System.out.println(stakk);
        Stack<Integer> stakk2 = (Stack<Integer>) stakk;
        stakk2.push(2);
        stakk2.push(4);
        System.out.println(stakk2.pop());

        MinListe minListe = new MinListe();
        minListe.leggTilNode(2);
        minListe.leggTilNode(4);
        minListe.leggTilNode(5);
        minListe.skrivUt();

    }
}
