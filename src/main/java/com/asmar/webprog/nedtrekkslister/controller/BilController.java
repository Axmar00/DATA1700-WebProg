package com.asmar.webprog.nedtrekkslister.controller;
import com.asmar.webprog.nedtrekkslister.model.Bil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BilController {

    @GetMapping("/hentBiler")
    public List<Bil> hentBiler() {
        List<Bil> biler = new ArrayList<>();
        biler.add(new Bil("Audi","A8"));
        biler.add(new Bil("BMW","Benz"));
        biler.add(new Bil("Nissan","Leaf"));
        return biler;
    }
}
