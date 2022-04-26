package com.asmar.webprog.sesjoner.controller;

import com.asmar.webprog.sesjoner.model.Bil;
import com.asmar.webprog.sesjoner.model.Motorvogn;
import com.asmar.webprog.sesjoner.repository.MotorvognRepository6;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/sesjoner")
public class MotorvognController6 {
    @Autowired
    MotorvognRepository6 rep;

    private Logger logger = LoggerFactory.getLogger(MotorvognController6.class);

    public boolean validerMotorvogn(Motorvogn innMotorvogn) {
        String regexPersonnr = "[0-9]{11}";
        String regexNavn = "[a-zA-ZæøåÆØÅ. \\-]{2,20}";
        String regexAdresse = "[0-9a-zA-ZæøåÆØÅ. \\-]{2,50}";
        String regexKjennetegn = "[A-Z][A-Z][0-9]{5}";
        boolean personnrOK = innMotorvogn.getPersonNr().matches(regexPersonnr);
        boolean navnOK = innMotorvogn.getNavn().matches(regexNavn);
        boolean adresseOK = innMotorvogn.getAdresse().matches(regexAdresse);
        boolean kjennetegnOK = innMotorvogn.getKjennetegn().matches(regexKjennetegn);

        if(personnrOK && navnOK && adresseOK && kjennetegnOK) {
            return true;
        }
        else {
            logger.error("Feil i validering");
            return false;
        }
    }

    @PostMapping("/lagre")
    public void lagreMotorvogn(Motorvogn innMotorvogn, HttpServletResponse response) throws IOException {
        if(!validerMotorvogn(innMotorvogn)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Valideringsfeil fra server");
        }
        else {
            if (!rep.lagreMotorvogn(innMotorvogn)) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Feil i database");
            }
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
        if(!validerMotorvogn(innMotorvogn)) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Valideringsfeil fra server");
        }
        else {
            if(!rep.endreMotorvogn(innMotorvogn)) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Feil i database");
            }
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