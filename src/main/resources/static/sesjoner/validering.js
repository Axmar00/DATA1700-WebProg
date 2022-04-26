function validerPersonnr(personnr) {
    const regexp = /^[0-9]{11}$/;
    const ok = regexp.test(personnr);

    if(ok) {
        $("#feilPersonnr").html("");
        return true;
    }
    else {
        $("#feilPersonnr").html("Personnummeret må bestå av 11 tall");
        return false;
    }
}

function validerNavn(navn) {
    const regexp = /^[a-zA-ZæøåÆØÅ. \-]{2,20}$/;
    const ok = regexp.test(navn);

    if(ok) {
        $("#feilNavn").html("");
        return true;
    }
    else {
        $("#feilNavn").html("Navnet må bestå av 2 til 20 bokstaver");
        return false;
    }
}

function validerAdresse(adresse) {
    const regexp = /[0-9a-zA-ZæøåÆØÅ. \-]{2,50}$/;
    const ok = regexp.test(adresse);

    if(ok) {
        $("#feilAdresse").html("");
        return true;
    }
    else {
        $("#feilAdresse").html("Adressen må bestå av 2 til 50 bokstaver og tall");
        return false;
    }
}

function validerKjennetegn(kjennetegn) {
    const regexp = /^[A-Z][A-Z][0-9]{5}$/;
    const ok = regexp.test(kjennetegn);

    if(ok) {
        $("#feilKjennetegn").html("");
        return true;
    }
    else {
        $("#feilKjennetegn").html("Kjennetegnet må bestå av 2 store bokstaver og 5 tall");
        return false;
    }
}

