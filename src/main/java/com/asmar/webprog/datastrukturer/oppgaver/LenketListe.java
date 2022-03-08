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

    public void slettNode(int slettVerdi) {
        Node node = hode;
        if(hode != null) {
            // hvis listen ikke er tom
            while (node != null) {
                Node nesteNode = node.neste;

                /*
                if(hode == hale) {
                // kun en node i listen
                if(hode.verdi == slettVerdi) {
                    hode = null;
                    hale = null;
                    return;
                }
                return;
            }

                if (node.verdi == slettVerdi) {
                    // hvis hode skal slettes
                    hode.neste = nesteNode.neste;
                    hode = nesteNode;
                    break;
                } else if (hale.verdi == slettVerdi) {
                    // hvis hale skal slettes

                }*/
                node = nesteNode;

            }
        }
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
            System.out.println();
        }
    }
    public static void main(String[] args) {
        LenketListe minListe = new LenketListe();
        minListe.leggTilNode(2);
        minListe.leggTilNode(4);
        minListe.leggTilNode(5);
        minListe.leggTilNode(9);
        minListe.leggTilNode(14);
        minListe.skrivUtListe();
        minListe.slettNode(2);
        minListe.skrivUtListe();
    }
}
