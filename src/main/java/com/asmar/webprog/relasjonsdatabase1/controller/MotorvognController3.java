package com.asmar.webprog.relasjonsdatabase1.controller;

import com.asmar.webprog.relasjonsdatabase1.model.Motorvogn;
import com.asmar.webprog.relasjonsdatabase1.repository.MotorvognRepository3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MotorvognController3 {
    @Autowired
    MotorvognRepository3 rep;

    @PostMapping("/lagreMotorvogn2")
    public void lagreMotorvogn2(Motorvogn innMotorvogn) {
        rep.lagreMotorvogn2(innMotorvogn);
    }

    @GetMapping("/hentAlleMotorvogner")
    public List<Motorvogn> hentAlleMotorvogner() {
        return rep.hentAlleMotorvogner();
    }

    @GetMapping("/slettAlleMotorvogner")
    public boolean slettAlleMotorvogner() {
        return rep.slettAlleMotorvogner();
    }
}
