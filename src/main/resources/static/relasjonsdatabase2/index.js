<!--------------------INNHENTING AV BILER-------------------->
const api = "/api/relasjonsdatabase2";
$(function () {
    hentMotorvogner();
});

function hentMotorvogner() {
    $.get(api + "/hentAlle", function(data) {
        formaterMotorvogner(data);
    });
}

function formaterMotorvogner(motorvogner) {
    let ut = "<table class='table table-striped'>" +
        "<tr>" +
        "<th>Personnr</th><th>Navn</th><th>Adresse</th><th>Kjennetegn</th><th>Merke</th><th>Type</th><th></th><th></th>" +
        "</tr>";

    for(let motorvogn of motorvogner) {
        ut += "<tr>" +
            "<td>" + motorvogn.personNr + "</td>" + "<td>" + motorvogn.navn + "</td>" + "<td>" + motorvogn.adresse + "</td>" +
            "<td>" + motorvogn.kjennetegn + "</td>" + "<td>" + motorvogn.merke + "</td>" + "<td>" + motorvogn.type + "</td>" +
            "<td> <a class='btn btn-primary' href='endre.html?id="+motorvogn.id+"'>Endre</a></td>" +
            "<td> <button class='btn btn-danger' onclick='slettEnMotorvogn("+motorvogn.id+")'>Slett</button></td>" +
            "</tr>";
    }
    ut += "</table>";
    $("#motorvognRegister").html(ut);
}

function slettMotorvogner() {
    $.get(api + "/slettAlle", function(data) {
            hentMotorvogner();
    });
}

function slettEnMotorvogn(id) {
    $.get(api + "/slettEn?id=" + id, function(data){
        hentMotorvogner();
    });
}