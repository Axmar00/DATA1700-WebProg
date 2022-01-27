//Oppgave 1
function visInfo() {
    let navn = $("#inputNavn").val();
    let alder = $("#inputAlder").val();
    if(alder < 1 || navn.trim == 0) {
        alert("Fyll ut alle feltene");
        return;
    }
    if(isNaN(Number(alder))) {
        alert("Alder må være et tall");
        return;
    }
    alert(navn + ": " + alder + " år gammel");
}

//Oppgave 2
function celsiusTilFarenheit(celsius) {
    $("#farenheit").val((9/5)*celsius+32);
}
function farenheitTilCelsius(farenheit){
    $("#celsius").val((5/9)*(farenheit-32));
}

//Oppgave 3
function pluss() {
    let sjekkFelt = validerFelt();
    let tall1 = Number($("#tall1").val());
    let tall2 = Number($("#tall2").val());

    if(sjekkFelt) {
        let sum = tall1+tall2;
        $("#resultat").html(" " + sum.toFixed(2));
    }
}
function minus() {
    let sjekkFelt = validerFelt();
    let tall1 = Number($("#tall1").val());
    let tall2 = Number($("#tall2").val());

    if(sjekkFelt) {
        let differanse = tall1-tall2;
        $("#resultat").html(" " + differanse.toFixed(2));
    }

}
function gange() {
    let sjekkFelt = validerFelt();
    let tall1 = Number($("#tall1").val());
    let tall2 = Number($("#tall2").val());

    if(sjekkFelt) {
        let produkt = tall1*tall2;
        $("#resultat").html(" " + produkt.toFixed(2));
    }

}
function dele() {
    let sjekkFelt = validerFelt();
    let tall1 = Number($("#tall1").val());
    let tall2 = Number($("#tall2").val());

    if(sjekkFelt) {
        let kvotient = tall1/tall2;
        $("#resultat").html(" " + kvotient.toFixed(2));
    }
}
function validerFelt() {
    let tall1 = $("#tall1").val();
    let tall2 = $("#tall2").val();

    if(tall1 == "" || tall2 == "") {
        $("#feilTall").html("Fyll ut alle feltene");
        $("#resultat").html("");
        return false;
    }
    else {
        $("#feilTall").html("");
        return true;
    }
}

//Oppgave 4
