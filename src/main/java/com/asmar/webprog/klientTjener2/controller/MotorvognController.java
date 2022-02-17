package com.asmar.webprog.klientTjener2.controller;

import com.asmar.webprog.klientTjener2.model.Bil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MotorvognController {
    private final List<Bil> biler = new ArrayList<>();

    @PostMapping("/lagre")
    public void lagreBil(Bil innBil) {
        biler.add(innBil);
    }

    @GetMapping("/hentAlle")
    public List<Bil> hentAlleBiler() {
        return biler;
    }

    @GetMapping("/slettAlle")
    public boolean slettAlle() {
        if(biler.isEmpty()) {
            System.err.println("Ingen biler registrert! Kan ikke tømme tomt array!");
            return false;
        }
        else {
            biler.clear();
            return true;
        }
    }
}
