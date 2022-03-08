package com.asmar.webprog.datastrukturer.demo;

import org.springframework.cglib.proxy.NoOp;

class Node {
    int data;
    Node neste;

    public Node(int data) {
        this.data = data;
    }
}

public class MinListe {
    private Node hode = null;
    private Node hale = null;

    public void leggTilNode(int value) {
        Node nyNode = new Node(value);
        if(hode == null) {
            hode = nyNode;
        }
        else {
            hale.neste = nyNode;
        }
        hale = nyNode;
        hale.neste = hode;
    }

    public void skrivUt() {
        Node denneNoden = hode;

        if(hode != null) {
            do {
                System.out.print(denneNoden.data + " ");
                denneNoden = denneNoden.neste;
            }while(denneNoden != hode);

        }
    }

}
