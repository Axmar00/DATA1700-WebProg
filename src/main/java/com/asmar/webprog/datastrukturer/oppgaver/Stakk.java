package com.asmar.webprog.datastrukturer.oppgaver;

public class Stakk {
    private static class Node {
        private int verdi;
        private Node neste;

        public Node(int verdi) {
            this.verdi = verdi;
        }
    }

    private Node topp;

    public Stakk() {
        this.topp = null;
    }

    public void push(int innVerdi) {
        Node nyNode = new Node(innVerdi);
        nyNode.neste = topp;
        topp = nyNode;
    }

    public int pop() {
        if(!tom()) {
            int temp = topp.verdi;
            topp = topp.neste;
            return temp;
        }
        System.out.println("Stakken er tom");
        return -1;
    }

    public boolean tom() {
        return topp == null;
    }

    public int peek() {
        if(!tom()) {
            return topp.verdi;
        }
        else {
            System.out.println("Stakken er tom!");
            return -1;
        }
    }

    public void skrivUt() {
        if(tom()) System.out.println("Stakken er tom");

        Node node = topp;
        while(node != null) {
            System.out.print(node.verdi + " ");
            node = node.neste;
        }
        System.out.println();
    }
}
