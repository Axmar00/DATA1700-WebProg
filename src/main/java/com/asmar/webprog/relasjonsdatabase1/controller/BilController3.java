package com.asmar.webprog.relasjonsdatabase1.controller;

import com.asmar.webprog.relasjonsdatabase1.model.Bil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BilController3 {
    private final List<Bil> biler = new ArrayList<>();

    @GetMapping("/hentBiler2")
    public List<Bil> hentBiler2() {
        List<Bil> biler = new ArrayList<>();
        biler.add(new Bil("Audi","A8"));
        biler.add(new Bil("Audi","A3"));
        biler.add(new Bil("Audi","RS4"));
        biler.add(new Bil("BMW","i4"));
        biler.add(new Bil("BMW","iX"));
        biler.add(new Bil("BMW","X5"));
        biler.add(new Bil("Nissan","Leaf"));
        biler.add(new Bil("Nissan","Leaf e+"));
        biler.add(new Bil("Nissan","Qashqai"));
        biler.add(new Bil("Tesla","Model S"));
        biler.add(new Bil("Tesla","Model X"));
        return biler;
    }
}
