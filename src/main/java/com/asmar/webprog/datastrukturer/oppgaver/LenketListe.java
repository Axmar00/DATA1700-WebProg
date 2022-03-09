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

    public LenketListe() {
        this.hode = null;
        this.hale = null;
    }


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
        hale.neste = hode;
    }

    public void slettNode(int slettVerdi) {
        Node node = hode;

        // hvis listen er tom
        if(hode == null) return;

        do {
            Node nesteNode = node.neste;
            if(nesteNode.verdi == slettVerdi) {
                if(hode == hale) {
                    // kun en verdi i listen
                    hode = null;
                    hale = null;
                }
                else {
                    // flere verdier i listen
                    node.neste = nesteNode.neste;
                    if(nesteNode == hode) {
                        // hodet skal slettes
                        hode = hode.neste;
                    }
                    if(nesteNode == hale) {
                        // halen skal slettes
                        hale = node;
                    }
                }
                break;
            }
            node = nesteNode;
        }while (node != hode);
    }

    public boolean inneholderNode(int sokeVerdi) {
        Node node = hode;
        if(hode != null) {
            // hvis listen ikke er tom
            do {
                if (node.verdi == sokeVerdi) {
                    return true;
                }
                node = node.neste;
            } while (node != hode);
        }
        return false;
    }

    public void skrivUtListe() {
        Node node = hode;
        if(hode != null) {
            do{
                System.out.print(node.verdi + " ");
                node = node.neste;
            }while(node != hode);
            System.out.println();
        }
    }
    public static void main(String[] args) {

    }
}
