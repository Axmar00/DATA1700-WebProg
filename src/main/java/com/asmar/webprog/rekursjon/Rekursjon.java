package com.asmar.webprog.rekursjon;

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

    // binærsøk (binary search)
    public static int binSearch(int[] liste, int nokkel, int venstre, int hoyre){
        if (venstre <= hoyre) {
            // splitter listen i to
            int mid = (venstre + hoyre) / 2;

            if (liste[ mid ] > nokkel) {
                // søk i venstre halvdel
                return binSearch(liste, nokkel, venstre, mid - 1);
            }
            else  if (liste[ mid ] < nokkel) {
                // søk i høyre halvdel
                return binSearch(liste, nokkel, mid + 1, hoyre);
            }
            else {
                // fant verdi!
                return mid;
            }
        }
        else {
            // tom liste,
            return -1;
        }
    }
}