package com.asmar.webprog.relasjonsdatabase2.controller;

import com.asmar.webprog.relasjonsdatabase2.model.Bil;
import com.asmar.webprog.relasjonsdatabase2.model.Motorvogn;
import com.asmar.webprog.relasjonsdatabase2.repository.MotorvognRepository4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/relasjonsdatabase2")
public class MotorvognController4 {
    @Autowired
    MotorvognRepository4 rep;

    @PostMapping("/lagre")
    public void lagreMotorvogn2(Motorvogn innMotorvogn) {
        rep.lagreMotorvogn2(innMotorvogn);
    }

    @GetMapping("/hentAlle")
    public List<Motorvogn> hentAlleMotorvogner() {
        return rep.hentAlleMotorvogner();
    }

    @GetMapping("/slettAlle")
    public boolean slettAlleMotorvogner() {
        return rep.slettAlleMotorvogner();
    }

    @GetMapping("/slettEn")
    public void slettEnMotorvogn(int id) {
        rep.slettEnMotorvogn(id);
    }

    @GetMapping("/hentBiler")
    public List<Bil> hentBiler() {
        return rep.hentBiler();
    }
}
