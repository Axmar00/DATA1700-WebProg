package com.asmar.webprog.relasjonsdatabase2.controller;

import com.asmar.webprog.relasjonsdatabase2.model.Bil;
import com.asmar.webprog.relasjonsdatabase2.model.Motorvogn;
import com.asmar.webprog.relasjonsdatabase2.repository.MotorvognRepository4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/relasjonsdatabase2")
public class MotorvognController4 {
    @Autowired
    MotorvognRepository4 rep;

    @PostMapping("/lagre")
    public void lagreMotorvogn(Motorvogn innMotorvogn, HttpServletResponse response) throws IOException {
        if(!rep.lagreMotorvogn(innMotorvogn)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Feil i database");
        }
    }

    @GetMapping("/hentAlle")
    public List<Motorvogn> hentAlleMotorvogner(HttpServletResponse response) throws IOException {
        List<Motorvogn> alleMotorvogner = rep.hentAlleMotorvogner();
        if(alleMotorvogner == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Feil i database");
        }
        return alleMotorvogner;
    }

    @GetMapping("/slettAlle")
    public void slettAlleMotorvogner(HttpServletResponse response) throws IOException {
        if(!rep.slettAlleMotorvogner()) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Feil i database");
        }
    }

    @GetMapping("/slettEn")
    public void slettEnMotorvogn(int id, HttpServletResponse response) throws IOException {
        if(!rep.slettEnMotorvogn(id)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Feil i database");
        }
    }

    @GetMapping("/hentEn")
    public Motorvogn hentEnMotorvogn(int id, HttpServletResponse response) throws IOException {
        Motorvogn enMotorvogn = rep.hentEnMotorvogn(id);
        if(enMotorvogn == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Feil i database");
        }
        return enMotorvogn;
    }

    @PostMapping("/endre")
    public void endreMotorvogn(Motorvogn innMotorvogn, HttpServletResponse response) throws IOException {
        if(!rep.endreMotorvogn(innMotorvogn)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Feil i database");
        }
    }

    @GetMapping("/hentBiler")
    public List<Bil> hentBiler(HttpServletResponse response) throws IOException {
        List<Bil> alleBiler = rep.hentBiler();
        if(alleBiler == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Feil i database");
        }
        return alleBiler;
    }
}