package com.asmar.webprog.rekursjon.oppgaver;

public class Rekursjon {
    // rekursiv fakultet
    public static long fakultet(long tall) {
        if(tall < 0) return -1;  // hvis tallet er negativt
        if(tall == 0) {
            return 1;
        }
        return tall * fakultet(tall - 1);
    }

    // rekursiv summasjon
    public static int sum(int tall) {
        if(tall < 0) return -1; // hvis tallet er negativt

        if(tall == 0){
            return 0;
        }
        return tall + sum(tall-1);
    }

    // iterativ summasjon
    public static int sum2(int tall) {
        if(tall < 0) return -1; // hvis tallet er negativt

        int sum = 0;
        for(int i = tall; tall > 0; tall--){
            sum += tall;
        }
        return sum;
    }
}
