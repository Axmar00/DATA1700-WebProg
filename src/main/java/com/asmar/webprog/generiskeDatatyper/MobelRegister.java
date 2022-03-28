package com.asmar.webprog.generiskeDatatyper;

import java.util.ArrayList;
import java.util.List;

public class MobelRegister {
    private final List<Mobel> mobler;

    public MobelRegister() {
        mobler = new ArrayList<>();
    }

    public void AddMobel(Mobel m) {
        mobler.add(m);
    }

    public Mobel getMobel(int nummer) {
        for(Mobel m : mobler) {
            if(m.getNummer() == nummer) {
                return m;
            }
        }
        return null;
    }

    public boolean removeMobel(int nummer) {
        for(Mobel m : mobler) {
            if(m.getNummer() == nummer) {
                mobler.remove(m);
                return true;
            }
        }
        return false;
    }

    public void printMobler() {
        for(Mobel m : mobler) {
            System.out.println(m);
        }
    }


}
