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
    public List<Motorvogn> hentAlleMotorvogner() {
        return rep.hentAlleMotorvogner();
    }

    @GetMapping("/slettAlle")
    public void slettAlleMotorvogner() {
        rep.slettAlleMotorvogner();
    }

    @GetMapping("/slettEn")
    public void slettEnMotorvogn(int id) {
        rep.slettEnMotorvogn(id);
    }

    @GetMapping("/hentEn")
    public Motorvogn hentEnMotorvogn(int id) {
        return rep.hentEnMotorvogn(id);
    }

    @PostMapping("/endre")
    public void endreMotorvogn(Motorvogn innMotorvogn) {
        rep.endreMotorvogn(innMotorvogn);
    }

    @GetMapping("/hentBiler")
    public List<Bil> hentBiler() {
        return rep.hentBiler();
    }
}
