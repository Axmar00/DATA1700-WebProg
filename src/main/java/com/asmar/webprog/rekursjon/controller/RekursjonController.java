package com.asmar.webprog.rekursjon.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RekursjonController {

    // rekursiv fakultet
    public long fak(long tall) {
        if(tall < 0) return -1;  // hvis tallet er negativt
        if(tall == 0) {
            return 1;
        }
        return tall * fak(tall - 1);
    }

    @GetMapping("/fakultet")
    public long fakultet(int tall) {
        return fak(tall);
    }


    // rekursiv summasjon
    public static int sum(int tall) {
        if(tall < 0) return -1; // hvis tallet er negativt

        if(tall == 0){
            return 0;
        }
        return tall + sum(tall-1);
    }

    @GetMapping("/summasjon")
    public int summasjon(int tall) {
        return sum(tall);
    }
}
