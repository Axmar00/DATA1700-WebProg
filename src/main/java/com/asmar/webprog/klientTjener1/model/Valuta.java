package com.asmar.webprog.klientTjener1.model;

public class Valuta {
    private String sort;
    private int kurs;

    public Valuta(String sort, int kurs) {
        this.sort = sort;
        this.kurs = kurs;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getKurs() {
        return kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }


}
