package com.asmar.webprog.klientTjener1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloServerController {
    @GetMapping("/halloserver")
    public String hei(String navn) {
        int antallBokstaver = navn.length();
        return "Hei verden " + navn + "! Navnet ditt er " + antallBokstaver + " langt.";
    }
}
