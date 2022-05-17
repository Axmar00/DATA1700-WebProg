DROP TABLE IF EXISTS Motorvogn;
CREATE TABLE Motorvogn
(
    id         INTEGER AUTO_INCREMENT NOT NULL,
    personnr   VARCHAR(255) NOT NULL,
    navn       VARCHAR(255) NOT NULL,
    adresse    VARCHAR(255) NOT NULL,
    kjennetegn VARCHAR(255) NOT NULL,
    merke      VARCHAR(255) NOT NULL,
    type       VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Bil;
CREATE TABLE Bil
(
    id INTEGER AUTO_INCREMENT NOT NULL,
    merke VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

/*--------------------MOTORVOGN4 TABELLER--------------------*/

DROP TABLE IF EXISTS Motorvogn4;
CREATE TABLE Motorvogn4
(
    id         INTEGER AUTO_INCREMENT NOT NULL,
    personnr   VARCHAR(255) NOT NULL,
    navn       VARCHAR(255) NOT NULL,
    adresse    VARCHAR(255) NOT NULL,
    kjennetegn VARCHAR(255) NOT NULL,
    merke      VARCHAR(255) NOT NULL,
    type       VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Bil4;
CREATE TABLE Bil4
(
    id INTEGER AUTO_INCREMENT NOT NULL,
    merke VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

/*--------------------MOTORVOGN5 TABELLER--------------------*/

DROP TABLE IF EXISTS Motorvogn5;
CREATE TABLE Motorvogn5
(
    id         INTEGER AUTO_INCREMENT NOT NULL,
    personnr   VARCHAR(255) NOT NULL,
    navn       VARCHAR(255) NOT NULL,
    adresse    VARCHAR(255) NOT NULL,
    kjennetegn VARCHAR(255) NOT NULL,
    merke      VARCHAR(255) NOT NULL,
    type       VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Bil5;
CREATE TABLE Bil5
(
    id INTEGER AUTO_INCREMENT NOT NULL,
    merke VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

/*--------------------MOTORVOGN6 TABELLER--------------------*/

DROP TABLE IF EXISTS Motorvogn6;
CREATE TABLE Motorvogn6
(
    id         INTEGER AUTO_INCREMENT NOT NULL,
    personnr   VARCHAR(255) NOT NULL,
    navn       VARCHAR(255) NOT NULL,
    adresse    VARCHAR(255) NOT NULL,
    kjennetegn VARCHAR(255) NOT NULL,
    merke      VARCHAR(255) NOT NULL,
    type       VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Bil6;
CREATE TABLE Bil6
(
    id INTEGER AUTO_INCREMENT NOT NULL,
    merke VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS Bruker6;
CREATE TABLE Bruker6
(
    id INTEGER AUTO_INCREMENT NOT NULL,
    brukernavn VARCHAR(255) NOT NULL,
    passord VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);