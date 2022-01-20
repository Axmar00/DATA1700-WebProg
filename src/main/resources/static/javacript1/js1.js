//Oppgave 1
function heiVerden(){
    document.write("Hei verden");
}

//Oppgave 2
function heiVerden2() {
    alert("Hei verden");
}

//Oppgave 3
function inputChange(inputVerdi) {
    document.write(inputVerdi);
}

//Oppgave 4
function printAlert(verdi) {
    alert(verdi);
}

//Oppgave 5
function writeConsole(verdi) {
    console.log(verdi);
}

<!--------------------EKSTRAOPPGAVER-------------------->

//Oppgave 6
function inputChange2(inputVerdi) {
    document.write(inputVerdi.fontcolor("blue"));
    //Alternativ måte:
    document.write("<p style='color: blue;'>" + inputVerdi + "</p>");
}

//Oppgave 7
function printAlert2(verdi) {
    alert(verdi.toUpperCase());
}

//Oppgave 8
function writeConsole2() {
    console.log(1);
}

//Oppgave 9
let antall = 0;
function writeConsole3() {
    antall++;
    console.log(antall);
}

//Oppgave 10
let antall2 = 0;
function writeConsole4() {
    antall2++;
    console.log("Du har trykket på knappen " + antall2 + " ganger.");
}