//personArray
const personer = [];

const person1 = {
    navn: "Sigrid Sandberg",
    adresse: "Havreveien 20",
    telefonNr: "45456777",
    fodselsNr: "04049646282"
};
const person2 = {
    navn: "Ivar Aasen",
    adresse: "Rabbeveien 38",
    telefonNr: "98045034",
    fodselsNr: "31120134135"
};
const person3 = {
    navn: "Ole Hansen",
    adresse: "Askerveien 48",
    telefonNr: "99887766",
    fodselsNr: "06010072749"
};
const person4 = {
    navn: "Grete Iversen",
    adresse: "Beverveien 5",
    telefonNr: "12345678",
    fodselsNr: "02040246882"
};
const person5 = {
    navn: "Leif Jensen",
    adresse: "Osloveien 23",
    telefonNr: "93546754",
    fodselsNr: "16120272385"
};
const person6 = {
    navn: "Ida Berntsen",
    adresse: "Drammensveien 4A",
    telefonNr: "98842674",
    fodselsNr: "17049923622"
};

personer.push(person1, person2, person3, person4, person5, person6);

let ut = "";
let ut2 = "";
function visPersonRegister() {
    //Print ut usortert array
    printArray();

    //Print ut usortert array
    printSortedArray()
}

function printArray() {
    //DivElement
    let personRegister = document.getElementById("personRegister");

    ut = "<h2> Usortert array </h2>" +
        "<table><tr>" +
        "<th>Navn</th><th>Adresse</th><th>Telefon</th><th>Fodselsnummer</th>" +
        "</tr>";
    //Går gjennom hele personarrayet
    for(let i in personer) {
        if(erKvinne(personer[i].fodselsNr)) {
            //Hvis personen er en kvinne
            if (i % 2 === 0) {
                ut += "<tr style='font-weight: bold; color: #be0000'>" +
                    "<td>" + personer[i].navn + "</td>" + "<td>" + personer[i].adresse + "</td>" + "<td>" + personer[i].telefonNr + "</td>" + "<td>" + personer[i].fodselsNr + "</td>" +
                    "</tr>";
            } else {
                ut += "<tr style='color: #be0000'>" +
                    "<td>" + personer[i].navn + "</td>" + "<td>" + personer[i].adresse + "</td>" + "<td>" + personer[i].telefonNr + "</td>" + "<td>" + personer[i].fodselsNr + "</td>" +
                    "</tr>";
            }
        }
        else {
            //Hvis personen er en mann
            if (i % 2 === 0) {
                ut += "<tr style='font-weight: bold; color: #0808ff'>" +
                    "<td>" + personer[i].navn + "</td>" + "<td>" + personer[i].adresse + "</td>" + "<td>" + personer[i].telefonNr + "</td>" + "<td>" + personer[i].fodselsNr + "</td>" +
                    "</tr>";
            } else {
                ut += "<tr style='color: #0808ff'>" +
                    "<td>" + personer[i].navn + "</td>" + "<td>" + personer[i].adresse + "</td>" + "<td>" + personer[i].telefonNr + "</td>" + "<td>" + personer[i].fodselsNr + "</td>" +
                    "</tr>";
            }
        }
    }
    ut += "</table><br><br><br>";
    personRegister.innerHTML = ut;
}

function printSortedArray() {
    //DivElement
    let personRegister = document.getElementById("personRegister");

    let personer2 = personer.slice();
    sortByName(personer2);

    ut2 = "<h2> Sortert array </h2>" +
        "<table><tr>" +
        "<th>Navn</th><th>Adresse</th><th>Telefon</th><th>Fodselsnummer</th>" +
        "</tr>";
    //Går gjennom hele personarrayet
    for(let i in personer2) {
        if(erKvinne(personer2[i].fodselsNr)) {
            //Hvis personen er en kvinne
            if (i % 2 === 0) {
                ut2 += "<tr style='font-weight: bold; color: #be0000'>" +
                    "<td>" + personer2[i].navn + "</td>" + "<td>" + personer2[i].adresse + "</td>" + "<td>" + personer2[i].telefonNr + "</td>" + "<td>" + personer2[i].fodselsNr + "</td>" +
                    "</tr>";
            } else {
                ut2 += "<tr style='color: #be0000'>" +
                    "<td>" + personer2[i].navn + "</td>" + "<td>" + personer2[i].adresse + "</td>" + "<td>" + personer2[i].telefonNr + "</td>" + "<td>" + personer2[i].fodselsNr + "</td>" +
                    "</tr>";
            }
        }
        else {
            //Hvis personen er en mann
            if (i % 2 === 0) {
                ut2 += "<tr style='font-weight: bold; color: #0808ff'>" +
                    "<td>" + personer2[i].navn + "</td>" + "<td>" + personer2[i].adresse + "</td>" + "<td>" + personer2[i].telefonNr + "</td>" + "<td>" + personer2[i].fodselsNr + "</td>" +
                    "</tr>";
            } else {
                ut2 += "<tr style='color: #0808ff'>" +
                    "<td>" + personer2[i].navn + "</td>" + "<td>" + personer2[i].adresse + "</td>" + "<td>" + personer2[i].telefonNr + "</td>" + "<td>" + personer2[i].fodselsNr + "</td>" +
                    "</tr>";
            }
        }
    }
    ut2 += "</table><br><br><br>";
    personRegister.innerHTML += ut2;
}

function sortByName(array) {
    array.sort( (pers1,pers2) => {
        let navn1 = pers1.navn.toLowerCase();
        let navn2 = pers2.navn.toLowerCase();

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

function erKvinne(fodselsnr) {
    let fnummer = fodselsnr.split("");
    let kjonnNummer = fnummer[8];
    //Kan også ta fodselsnr.toString()[8]

    return kjonnNummer % 2 === 0;
}