//Oppgave 1
function visInfo() {
    let navn = $("#inputNavn").val();
    let alder = $("#inputAlder").val();
    if(alder < 1 || navn == 0) {
        alert("Fyll ut alle feltene");
        return;
    }
    if(isNaN(Number(alder))) {
        alert("Alder må være et tall");
        return;
    }
    alert(navn + ": " + alder + " år gammel");
}

//Oppgave 2
function celsiusTilFarenheit(celsius) {
    $("#farenheit").val((9/5)*celsius+32);
}
function farenheitTilCelsius(farenheit){
    $("#celsius").val((5/9)*(farenheit-32));
}

//Oppgave 3
function pluss() {
    let sjekkFelt = validerFelt();
    let tall1 = Number($("#tall1").val());
    let tall2 = Number($("#tall2").val());

    if(sjekkFelt) {
        let sum = tall1+tall2;
        $("#resultat").html(" " + sum.toFixed(2));
    }
}
function minus() {
    let sjekkFelt = validerFelt();
    let tall1 = Number($("#tall1").val());
    let tall2 = Number($("#tall2").val());

    if(sjekkFelt) {
        let differanse = tall1-tall2;
        $("#resultat").html(" " + differanse.toFixed(2));
    }

}
function gange() {
    let sjekkFelt = validerFelt();
    let tall1 = Number($("#tall1").val());
    let tall2 = Number($("#tall2").val());

    if(sjekkFelt) {
        let produkt = tall1*tall2;
        $("#resultat").html(" " + produkt.toFixed(2));
    }

}
function dele() {
    let sjekkFelt = validerFelt();
    let tall1 = Number($("#tall1").val());
    let tall2 = Number($("#tall2").val());

    if(sjekkFelt) {
        let kvotient = tall1/tall2;
        $("#resultat").html(" " + kvotient.toFixed(2));
    }
}
function validerFelt() {
    let tall1 = $("#tall1").val();
    let tall2 = $("#tall2").val();

    if(tall1 == "" || tall2 == "") {
        $("#feilTall").html("Fyll ut alle feltene");
        $("#resultat").html("");
        return false;
    }
    else {
        $("#feilTall").html("");
        return true;
    }
}

//Oppgave 4
const personer = [];
let ut = "";

function registrer() {
    let fornavnOK = validerFornavn();
    let adresseOK = validerAdresse();
    let telefonnrOK = validerTelefonnr();
    let OK = fornavnOK && adresseOK && telefonnrOK;


    if(OK) {
        let fornavn = $("#fornavn").val();
        let adresse = $("#adresse").val();
        let tlfnr = $("#telefonNr").val();
        const person = {
            fornavn: fornavn,
            adresse: adresse,
            telefonNr: tlfnr
        };
        personer.push(person);
        $("#fornavn").val("");
        $("#adresse").val("");
        $("#telefonNr").val("");
        alert(fornavn + " registrert");
    }
}

function visPersonRegister() {
    //Print ut usortert array
    printSortedArray()
}

function printSortedArray() {
    let personRegister = $("#personRegister");
    sortByName(personer);

    ut = "<h2> Sortert array </h2>" +
        "<table><tr>" +
        "<th>Fornavn</th><th>Adresse</th><th>Telefon</th>" +
        "</tr>";
    //Går gjennom hele personarrayet
    for(let i in personer) {
        if (i % 2 === 0) {
            ut += "<tr style='font-weight: bold'>" +
                "<td>" + personer[i].fornavn + "</td>" + "<td>" + personer[i].adresse + "</td>" + "<td>" + personer[i].telefonNr + "</td>" +
                "</tr>";
        } else {
            ut += "<tr>" +
                "<td>" + personer[i].fornavn + "</td>" + "<td>" + personer[i].adresse + "</td>" + "<td>" + personer[i].telefonNr + "</td>" +
                "</tr>";
        }
    }
    ut += "</table><br><br><br>";
    personRegister.html(ut);
}

function sortByName(array) {
    array.sort( (pers1,pers2) => {
            let navn1 = pers1.fornavn.toLowerCase();
            let navn2 = pers2.fornavn.toLowerCase();

            if(navn1 > navn2) {
                return 1;
            }
            else if(navn1 < navn2) {
                return -1;
            }
            else {
                return 0;
            }
        }
    );
}

function validerFornavn() {
    let fornavn = $("#fornavn").val();
    let feilFornavn = $("#feilFornavn");
    const regexp = /^[a-zA-ZæøåÆØÅ\.\ \-]{2,15}$/;
    const ok = regexp.test(fornavn);

    if(fornavn == 0) {
        feilFornavn.html("Må skrive noe i fornavn");
        return false;
    }
    else if(!ok) {
        feilFornavn.html("Kun 2-15 bokstaver! Tall og spesialtegn ikke gyldig");
        return false;
    }
    else {
        feilFornavn.html("");
        return true;
    }
}

function validerAdresse() {
    let adresse = $("#adresse").val();
    let feilAdresse = $("#feilAdresse");

    if(adresse == 0) {
        feilAdresse.html("Må skrive noe i adresse");
        return false;
    }
    else {
        feilAdresse.html("");
        return true;
    }
}

function validerTelefonnr() {
    let telefonNr = $("#telefonNr").val();
    let feilTlfnr = $("#feilTlfnr");
    const regexp = /^[0-9]{8}$/;
    const ok = regexp.test(telefonNr);

    if(telefonNr == 0) {
        feilTlfnr.html("Må skrive noe i telefonnummer");
        return false
    }
    else if(!ok) {
        feilTlfnr.html("Kun 8 tall! Bokstaver ikke gyldig!");
        return false;
    }
    else {
        feilTlfnr.html("");
        return true;
    }
}


<!--------------------EKSTRAOPPGAVER-------------------->

//Oppgave 5
function sendGjoremal() {
    let gjoremal = $("#gjoreMal");
    let liste = $("#gjoremalListe");
    let ut;

    if(gjoremal.val() == 0) {
        return;
    }
    else {
        ut += "<li>" +
              "<input type='checkbox'>" + gjoremal.val() +
              "</li>";
        liste.append(ut);
        gjoremal.val("");
    }
}