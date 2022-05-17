const api = "/api/sesjoner";
function loggInn() {
    const bruker = {
        brukernavn: $("#brukernavn").val(),
        passord: $("#passord").val()
    };

    $.get(api + "/loggInn", bruker, function(OK) {
        if(OK) {
            window.location.href = "hjem.html";
        }
        else {
            $("#feil").html("Feil brukernavn eller passord");
        }
    }).fail(function(jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feilMelding").html(json.message);
    });
}