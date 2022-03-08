package com.asmar.webprog.rekursjon.demo;

public class Rekursjon {
    public static void main(String[] args) {
        skrivHei(4);
    }

    public static void skrivHei(int antall) {
        if(antall > 0) {
            System.out.println("Hei!");
            skrivHei(antall -1);
        }
        System.out.println("Hoi");
    }
}
