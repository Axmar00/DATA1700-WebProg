package com.asmar.webprog.inputvalidering.controller;

import com.asmar.webprog.inputvalidering.model.Bil;
import com.asmar.webprog.inputvalidering.model.Motorvogn;
import com.asmar.webprog.inputvalidering.repository.MotorvognRepository5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/inputvalidering")
public class MotorvognController5 {
    @Autowired
    MotorvognRepository5 rep;

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

    @DeleteMapping("/slettAlle")
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