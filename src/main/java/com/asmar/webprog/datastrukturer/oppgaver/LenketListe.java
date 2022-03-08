package com.asmar.webprog.datastrukturer.oppgaver;

import com.asmar.webprog.datastrukturer.demo.MinListe;

class Node {
    int verdi;
    Node neste;

    public Node(int verdi) {
        this.verdi = verdi;
    }
}

public class LenketListe {
    private Node hode = null;
    private Node hale = null;

    public void leggTilNode(int verdi)  {
        Node nyNode = new Node(verdi);
        if(hode == null) {
            // listen er tom
            hode = nyNode;
        }
        else {
            // listen er ikke tom
            hale.neste = nyNode;
        }
        hale = nyNode;
    }

    public void slettNode() {

    }

    public boolean inneholderNode(int sokeVerdi) {
        Node node = hode;
        if(hode != null) {
            while (node != null) {
                if (node.verdi == sokeVerdi) {
                    return true;
                }
                node = node.neste;
            }
        }
        return false;
    }

    public void skrivUtListe() {
        Node node = hode;
        if(hode != null) {
            do{
                System.out.print(node.verdi + " ");
                node = node.neste;
            }while(node != null);
        }
    }
    public static void main(String[] args) {
        LenketListe minListe = new LenketListe();
        minListe.leggTilNode(2);
        minListe.leggTilNode(4);
        minListe.leggTilNode(5);
        System.out.println(minListe.inneholderNode(5));
    }
}
