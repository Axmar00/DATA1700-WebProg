function registrer() {
    const bil = {
        personNr: $("#inputPersonNr").val(),
        navn: $("#inputNavn").val(),
        adresse: $("#inputAdresse").val(),
        kjennetegn: $("#inputKjennetegn").val(),
        bilMerke: $("#inputMerke").val(),
        bilType: $("#inputType").val()
    };
    $.post("/lagre", bil, function(){
        console.log(bil.navn + " sin " + bil.bilMerke + " er registrert!");
        hentAlleBiler();
    });

    $("#inputPersonNr").val("");
    $("#inputNavn").val("");
    $("#inputAdresse").val("");
    $("#inputKjennetegn").val("");
    $("#inputMerke").val("");
    $("#inputType").val("");
    $("#feilMelding").html("");
}

function hentAlleBiler() {
    $.get("/hentAlle", function(data){
        formaterRegister(data);
    });
}

function formaterRegister(biler) {
    let ut = "<table class='table table-striped'>" +
        "<tr>" +
        "<th>Personnr</th><th>Navn</th><th>Adresse</th><th>Kjennetegn</th><th>Merke</th><th>Type</th>" +
        "</tr>";
    for(let bil of biler) {
        ut += "<tr>" +
            "<td>" + bil.personNr + "</td>" + "<td>" + bil.navn + "</td>" + "<td>" + bil.adresse + "</td>" +
            "<td>" + bil.kjennetegn + "</td>" + "<td>" + bil.bilMerke + "</td>" + "<td>" + bil.bilType + "</td>" +
            "</tr>";
    }
    ut += "</table>";
    $("#motorvognRegister").html(ut);
}

function slettAlle() {
    $.get("/slettAlle", function(data){
        if(data) {
            $("#feilMelding").html("");
            hentAlleBiler();
        }
        else {
            $("#feilMelding").html("Ingen biler registrert");
        }
    });
}