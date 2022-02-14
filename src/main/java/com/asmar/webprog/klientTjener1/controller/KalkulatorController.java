package com.asmar.webprog.klientTjener1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KalkulatorController {
    @GetMapping("/pluss")
    public double pluss(double tall1, double tall2) {
        try {
            return tall1 + tall2;
        } catch(Exception e) {
            System.err.println("Feil fra server: " + e);
            return 0;
        }
    }

    @GetMapping("/minus")
    public double minus(double tall1, double tall2) {
        try {
            return tall1 - tall2;
        } catch(Exception e) {
            System.err.println("Feil fra server: " + e);
            return 0;
        }
    }

    @GetMapping("/gange")
    public double gange(double tall1, double tall2) {
        try {
            return tall1 * tall2;
        } catch(Exception e) {
            System.err.println("Feil fra server: " + e);
            return 0;
        }
    }

    @GetMapping("/dele")
    public double dele(double tall1, double tall2) {
        try {
            return tall1 / tall2;
        } catch(Exception e) {
            System.err.println("Feil fra server: " + e);
            return 0;
        }
    }
}
