const api = "/api/relasjonsdatabase2";
$(function() {
    const id = window.location.search.substring(1);
    $.get(api + "/hentEn?" + id, function(data) {

    })
})