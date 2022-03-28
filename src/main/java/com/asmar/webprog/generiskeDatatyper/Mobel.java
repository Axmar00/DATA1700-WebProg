package com.asmar.webprog.generiskeDatatyper;

abstract public class Mobel implements Comparable<Mobel> {
    String navn, type;
    int vekt, pris, nummer;

    public Mobel(String navn, String type, int vekt, int pris, int nummer) {
        this.navn = navn;
        this.type = type;
        this.vekt = vekt;
        this.pris = pris;
        this.nummer = nummer;
    }

    public abstract String toString();

    public abstract int compareTo(Mobel m);

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVekt() {
        return vekt;
    }

    public void setVekt(int vekt) {
        this.vekt = vekt;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
}
