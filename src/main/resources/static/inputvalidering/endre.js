const api = "/api/inputvalidering";
let biler = [];
$(function() {
    hentBiler();
    hentEnMotorvogn();
});

function hentEnMotorvogn() {
    const id = window.location.search.substring(1);
    $.get(api + "/hentEn?" + id, function(data) {
        $("#id").val(data.id);
        $("#inputPersonNr").val(data.personNr);
        $("#inputNavn").val(data.navn);
        $("#inputAdresse").val(data.adresse);
        $("#inputKjennetegn").val(data.kjennetegn);
        $("#valgtMerke").val(data.merke);
        hentTyper();
        $("#valgtType").val(data.type);
        //setTimeout(() => { $("#valgtType").val(data.type); }, 500);

    }).fail(function(jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feilMelding").html(json.message);
    });
}

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

    let ut = "<select onchange='hentTyper()' id='valgtMerke'>";
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

function validerOgEndreMotorvogn() {
    const personnrOK = validerPersonnr($("#inputPersonNr").val());
    const navnOK = validerNavn($("#inputNavn").val());
    const adresseOK = validerAdresse($("#inputAdresse").val());
    const kjennetegnOK = validerKjennetegn($("#inputKjennetegn").val());

    const OK = personnrOK && navnOK && adresseOK && kjennetegnOK;
    if(OK) {
        endreMotorvogn();
    }
}

function endreMotorvogn() {
    const motorvogn = {
        id: $("#id").val(),
        personNr: $("#inputPersonNr").val(),
        navn: $("#inputNavn").val(),
        adresse: $("#inputAdresse").val(),
        kjennetegn: $("#inputKjennetegn").val(),
        merke: $("#valgtMerke").val(),
        type: $("#valgtType").val()
    };

    $.post(api + "/endre", motorvogn, function() {
        window.location.href="hjem.html";
    }).fail(function(jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feilMelding").html(json.message);
    });
}