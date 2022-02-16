function registrer() {
    const bil = {
        personNr: $("#inputPersonNr").val(),
        navn: $("#inputNavn").val(),
        adresse: $("#inputAdresse").val(),
        kjennetegn: $("#inputKjennetegn").val(),
        bilMerke: $("#inputMerke").val(),
        bilType: $("#inputType")
    };

    $.post("/lagre", bil, function(){
        console.log("Kunde lagret");
        hentAlleBiler();
    });
}

function hentAlleBiler() {
    $.get("/hentAlle", function(data){
        formaterRegister(data);
    });
}

function formaterRegister(biler) {

}