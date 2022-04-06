<!--------------------INNHENTING AV BILER-------------------->
const api = "/api/relasjonsdatabase2"
let biler = [];
$(function () {
    hentBiler();
});

function hentBiler() {
    $.get(api + "/hentBiler", function(data){
        biler = data;
        formaterBiler(data);
    }).fail(function(jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feilMelding").html(json.message);
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

/*--------------------MOTORVOGN-REGISTRERING--------------------*/
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

    $.post(api + "/lagre", motorvogn, function() {
        window.location.href="index.html";
    }).fail(function(jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feilMelding").html(json.message);
    });
}