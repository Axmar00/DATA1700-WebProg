function fakultet() {
    let tall = $("#inputFakultet").val();

    $.get("/fakultet?tall=" + tall, function(data){
        $("#outputFakultet").html("= " + data);
    });
}

function summasjon() {
    let tall = $("#inputSummasjon").val();

    $.get("/summasjon?tall=" + tall, function(data){
        $("#outputSummasjon").html("= " + data);
    });
}