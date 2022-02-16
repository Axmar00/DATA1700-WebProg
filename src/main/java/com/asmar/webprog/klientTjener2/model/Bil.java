package com.asmar.webprog.klientTjener2.model;

public class Bil {
    private String personNr;
    private String navn;
    private String adresse;
    private String kjennetegn;
    private String bilMerke;
    private String bilType;

    public Bil(String personNr, String navn, String adresse, String kjennetegn, String bilMerke, String bilType) {
        this.personNr = personNr;
        this.navn = navn;
        this.adresse = adresse;
        this.kjennetegn = kjennetegn;
        this.bilMerke = bilMerke;
        this.bilType = bilType;
    }

    public Bil() {

    }

    public String getPersonNr() {
        return personNr;
    }

    public void setPersonNr(String personNr) {
        this.personNr = personNr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getKjennetegn() {
        return kjennetegn;
    }

    public void setKjennetegn(String kjennetegn) {
        this.kjennetegn = kjennetegn;
    }

    public String getBilMerke() {
        return bilMerke;
    }

    public void setBilMerke(String bilMerke) {
        this.bilMerke = bilMerke;
    }

    public String getBilType() {
        return bilType;
    }

    public void setBilType(String bilType) {
        this.bilType = bilType;
    }
}
