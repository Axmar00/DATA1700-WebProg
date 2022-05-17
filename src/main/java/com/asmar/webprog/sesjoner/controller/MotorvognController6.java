package com.asmar.webprog.sesjoner.controller;

import com.asmar.webprog.sesjoner.model.Bil;
import com.asmar.webprog.sesjoner.model.Bruker;
import com.asmar.webprog.sesjoner.model.Motorvogn;
import com.asmar.webprog.sesjoner.repository.MotorvognRepository6;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/sesjoner")
public class MotorvognController6 {
    @Autowired
    private MotorvognRepository6 rep;

    @Autowired
    private HttpSession session;

    private final Logger logger = LoggerFactory.getLogger(MotorvognController6.class);

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
        if((boolean)session.getAttribute("Innlogget")) {
            if (!validerMotorvogn(innMotorvogn)) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Valideringsfeil fra server");
            } else {
                if (!rep.lagreMotorvogn(innMotorvogn)) {
                    response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            "Feil i database");
                }
            }
        } else {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Kan ikke lagre: Du er ikke logget inn!");
        }
    }

    @GetMapping("/hentAlle")
    public List<Motorvogn> hentAlleMotorvogner(HttpServletResponse response) throws IOException {
        List<Motorvogn> alleMotorvogner = rep.hentAlleMotorvogner();
        if (alleMotorvogner == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Feil i database");
        }
        return alleMotorvogner;
    }

    @GetMapping("/slettAlle")
    public void slettAlleMotorvogner(HttpServletResponse response) throws IOException {
        if((boolean)session.getAttribute("Innlogget")) {
            if (!rep.slettAlleMotorvogner()) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Feil i database");
            }
        } else {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Kan ikke slette: Du er ikke logget inn!");
        }
    }

    @GetMapping("/slettEn")
    public void slettEnMotorvogn(int id, HttpServletResponse response) throws IOException {
        if((boolean)session.getAttribute("Innlogget")) {
            if(!rep.slettEnMotorvogn(id)) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Feil i database");
            }
        } else {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Kan ikke slette: Du er ikke logget inn!");
        }
    }

    @GetMapping("/hentEn")
    public Motorvogn hentEnMotorvogn(int id, HttpServletResponse response) throws IOException {
        if((boolean)session.getAttribute("Innlogget")) {
            Motorvogn enMotorvogn = rep.hentEnMotorvogn(id);
            if (enMotorvogn == null) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Feil i database");
            }
            return enMotorvogn;
        } else {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Kan ikke slette: Du er ikke logget inn!");
            return null;
        }
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
        if((boolean)session.getAttribute("Innlogget")) {
            List<Bil> alleBiler = rep.hentBiler();
            if (alleBiler == null) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Feil i database");
            }
            return alleBiler;
        } else {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Kan ikke hente biler: Du er ikke logget inn!");
            return null;
        }
    }

    @GetMapping("/loggInn")
    public boolean loggInn(Bruker innBruker) {
        if(rep.sjekkBruker(innBruker)) {
            session.setAttribute("Innlogget",true);
            return true;
        }
        return false;
    }

    @GetMapping("/loggUt")
    public void loggUt() {
        session.setAttribute("Innlogget", false);
    }
}