function pluss() {
    let gyldigTall = validerFelt();
    let tall1 = $("#tall1");
    let tall2 = $("#tall2");
    let result = $("#resultat");
    const url = "/pluss?tall1=" + tall1.val() + "&tall2=" + tall2.val();

    if(gyldigTall) {
        $.get(url, function(data){
            result.html(tall1.val() + " + " + tall2.val() + " = " + data);
        });
    }
    else {
        result.html("");
    }
}

function minus() {
    let gyldigTall = validerFelt();
    let tall1 = $("#tall1");
    let tall2 = $("#tall2");
    let result = $("#resultat");
    const url = "/minus?tall1=" + tall1.val() + "&tall2=" + tall2.val();

    if(gyldigTall) {
        $.get(url, function(data){
            result.html(tall1.val() + " - " + tall2.val() + " = " + data);
        });
    }
    else {
        result.html("");
    }
}

function gange() {
    let gyldigTall = validerFelt();
    let tall1 = $("#tall1");
    let tall2 = $("#tall2");
    let result = $("#resultat");
    const url = "/gange?tall1=" + tall1.val() + "&tall2=" + tall2.val();

    if(gyldigTall) {
        $.get(url, function(data){
            result.html(tall1.val() + " * " + tall2.val() + " = " + data);
        });
    }
    else {
        result.html("");
    }
}

function dele() {
    let gyldigTall = validerFelt();
    let tall1 = $("#tall1");
    let tall2 = $("#tall2");
    let result = $("#resultat");
    const url = "/dele?tall1=" + tall1.val() + "&tall2=" + tall2.val();

    if(tall2.val() === "0") {
        $("#feilTall").html("Kan ikke dele på 0!");
        result.html("");
    }
    else if(gyldigTall) {
        $.get(url, function(data){
            result.html(tall1.val() + " / " + tall2.val() + " = " + data);
        });
    }
    else {
        result.html("");
    }
}

function validerFelt() {
    let tall1 = $("#tall1").val();
    let tall2 = $("#tall2").val();

    if(tall1 == "" || tall2 == "" || isNaN(tall1) || isNaN(tall2)) {
        $("#feilTall").html("Feil fra klient: Må oppgi to tall!");
        return false;
    }
    else {
        $("#feilTall").html("");
        return true;
    }
}
