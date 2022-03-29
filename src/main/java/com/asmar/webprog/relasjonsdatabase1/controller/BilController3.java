package com.asmar.webprog.relasjonsdatabase1.controller;

import com.asmar.webprog.relasjonsdatabase1.model.Bil;
import com.asmar.webprog.relasjonsdatabase1.repository.MotorvognRepository3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BilController3 {

    @Autowired
    MotorvognRepository3 rep;

    @GetMapping("/hentBiler2")
    public List<Bil> hentBiler2() {
        return rep.hentAlleBiler();
    }
}
