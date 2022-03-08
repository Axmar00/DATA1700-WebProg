<!--------------------INNHENTING AV BILER-------------------->
let biler = [];
$(function () {
    hentBiler();
});

function hentBiler() {
    $.get("/hentBiler", function(data){
        biler = data;
        formaterBiler(data);
    });
}

function formaterBiler(biler) {
    // lager en ny liste med bilmerker uten duplikater
    let unikeMerker = biler.map(bil => bil.merke).filter((merke, i, merker) => merker.indexOf(merke) === i);

    let ut = "<select onclick='hentTyper()' id='valgtMerke'>";
    for(const merke of unikeMerker) {
        ut += "<option value='"+merke+"'>" + merke + "</option>";
    }
    ut += "</select>";
    $("#bilMerker").html(ut);
}

function hentTyper() {
    let valgtMerke = $("#valgtMerke").val();
    const bilArray = biler.filter((bil) => bil.merke === valgtMerke);
    let ut = "<select id='valgtType'>";

    for(const bil of bilArray) {
        ut += "<option value='"+bil.type+"'>" + bil.type + "</option>"
    }
    ut += "</select>";
    $("#bilTyper").html(ut);
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