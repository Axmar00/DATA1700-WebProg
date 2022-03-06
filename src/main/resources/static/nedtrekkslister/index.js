<!--------------------INNHENTING AV BILER-------------------->
$(function () {
    hentBiler();
});

function hentBiler() {
    $.get("/hentBiler", function(data){
        formaterBiler(data);
    });
}

function formaterBiler(biler) {
    let ut = "<select id='valgtMerke'>";
    let ut2 = "<select id='valgtType'>";
    for(const bil of biler) {
        ut += "<option value='"+bil.merke+"'>" + bil.merke + "</option>";
        ut2 += "<option value='"+bil.type+"'>" + bil.type + "</option>"
    }
    ut += "</select>";
    ut2 += "</select>";
    $("#bilMerker").html(ut);
    $("#bilTyper").html(ut2);
}


<!--------------------LAGRING OG SLETTING-------------------->
function registrerMotorvogn() {
    let personNr = $("#inputPersonNr");
    let navn = $("#inputNavn");
    let adresse = $("#inputAdresse");
    let kjennetegn = $("#inputKjennetegn");
    let merke = $("#valgtMerke");
    let type = $("#valgtType");

    const motorvogn = {
        personNr: personNr.val(),
        navn: navn.val(),
        adresse: adresse.val(),
        kjennetegn: kjennetegn.val(),
        merke: merke.val(),
        type: type.val()
    };

    $.post("/lagreMotorvogn", motorvogn, function() {
        hentMotorvogner();
    });
}

function hentMotorvogner() {
    $.get("/hentMotorvogner", function(data) {
        formaterMotorvogner(data);
    });
}

function formaterMotorvogner(motorvogner) {
    let ut = "<table class='table table-striped'>" +
        "<tr>" +
        "<th>Personnr</th><th>Navn</th><th>Adresse</th><th>Kjennetegn</th><th>Merke</th><th>Type</th>" +
        "</tr>";

    for(let motorvogn of motorvogner) {
        ut += "<tr>" +
            "<td>" + motorvogn.personNr + "</td>" + "<td>" + motorvogn.navn + "</td>" + "<td>" + motorvogn.adresse + "</td>" +
            "<td>" + motorvogn.kjennetegn + "</td>" + "<td>" + motorvogn.merke + "</td>" + "<td>" + motorvogn.type + "</td>" +
            "</tr>";
    }
    ut += "</table>";
    $("#motorvognRegister").html(ut);
}

function slettMotorvogner() {
    $.get("/slettMotorvogner", function(data) {
        if(data) {
            $("#feilMelding").html("");
            hentMotorvogner();
        }
        else {
            $("#feilMelding").html("Ingen biler registert");
        }
    })
}