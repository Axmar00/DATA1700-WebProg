package com.asmar.webprog.nedtrekkslister.controller;

import com.asmar.webprog.nedtrekkslister.model.Motorvogn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MotorvognController2 {
    private final List<Motorvogn> motorvogner = new ArrayList<>();

    @PostMapping("/lagreMotorvogn")
    public void lagreMotorvogn(Motorvogn innMotorvogn) {
        motorvogner.add(innMotorvogn);
    }

    @GetMapping("/hentMotorvogner")
    public List<Motorvogn> hentMotorvogner() {
        return motorvogner;
    }

    @GetMapping("/slettMotorvogner")
    public boolean slettAlle() {
        if(motorvogner.isEmpty()) {
            return false;
        }
        else {
            motorvogner.clear();
            return true;
        }
    }
}
