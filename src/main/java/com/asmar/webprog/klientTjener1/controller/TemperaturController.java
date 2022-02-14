package com.asmar.webprog.klientTjener1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperaturController {
    private final Integer[] tempArray = new Integer[]{-3,-2,2,7,12,16,18,17,12,7,3,-2};

    public int getTemp(String mnd) {
        switch(mnd) {
            case "Januar":
            case "januar":
                return tempArray[0];
            case "Februar":
            case "februar":
                return tempArray[1];
            case "Mars":
            case "mars":
                return tempArray[2];
            case "April":
            case "april":
                return tempArray[3];
            case "Mai":
            case "mai":
                return tempArray[4];
            case "Juni":
            case "juni":
                return tempArray[5];
            case "Juli":
            case "juli":
                return tempArray[6];
            case "August":
            case "august":
                return tempArray[7];
            case "September":
            case "september":
                return tempArray[8];
            case "Oktober":
            case "oktober":
                return tempArray[9];
            case "November":
            case "november":
                return tempArray[10];
            case "Desember":
            case "desember":
                return tempArray[11];
            default:
                System.err.println("Feil fra server: Ikke gyldig månedsnavn ");
                return 404;
        }
    }

    @GetMapping("/hentTemp")
    public int hentTemp(String mnd) {
        return getTemp(mnd);
    }



}
