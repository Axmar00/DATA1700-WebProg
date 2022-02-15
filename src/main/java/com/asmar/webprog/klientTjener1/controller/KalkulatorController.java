package com.asmar.webprog.klientTjener1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KalkulatorController {
    @GetMapping("/pluss")
    public double pluss(String tall1, String tall2) {
        double utTall1;
        double utTall2;
        try {
            utTall1 = Double.parseDouble(tall1);
            utTall2 = Double.parseDouble(tall2);
        } catch(Exception e) {
            System.err.println("Feil fra server: " + e);
            return 0;
        }
        return utTall1 + utTall2;
    }

    @GetMapping("/minus")
    public double minus(String tall1, String tall2) {
        double utTall1;
        double utTall2;
        try {
            utTall1 = Double.parseDouble(tall1);
            utTall2 = Double.parseDouble(tall2);
        } catch(Exception e) {
            System.err.println("Feil fra server: " + e);
            return 0;
        }
        return utTall1 - utTall2;
    }

    @GetMapping("/gange")
    public double gange(String tall1, String tall2) {
        double utTall1;
        double utTall2;
        try {
            utTall1 = Double.parseDouble(tall1);
            utTall2 = Double.parseDouble(tall2);
        } catch(Exception e) {
            System.err.println("Feil fra server: " + e);
            return 0;
        }
        return utTall1 * utTall2;
    }

    @GetMapping("/dele")
    public double dele(String tall1, String tall2) {
        double utTall1;
        double utTall2;
        double resultat;
        try {
            utTall1 = Double.parseDouble(tall1);
            utTall2 = Double.parseDouble(tall2);
            if(utTall2 == 0 || utTall2 == 0.0) {
                throw new ArithmeticException("Feil fra server: Kan ikke dele på 0!");
            }
        } catch(Exception e) {
            System.err.println("Feil fra server: " + e);
            return 0;
        }
        return utTall1 / utTall2;
    }
}