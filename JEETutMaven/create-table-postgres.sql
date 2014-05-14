DROP TABLE IF EXISTS users; 
DROP TABLE IF EXISTS user_roles; 
DROP TABLE IF EXISTS nutzer;
DROP TABLE IF EXISTS kategorien;
DROP TABLE IF EXISTS artikel;
DROP TABLE IF EXISTS los;

DROP SEQUENCE IF EXISTS user_id_seq;

CREATE SEQUENCE user_id_seq;

CREATE TABLE users (
    id INTEGER NOT NULL default nextval('user_id_seq'),
    user_name VARCHAR(20) NOT NULL,
    user_pass VARCHAR(50) NOT NULL
);

INSERT INTO users (user_name, user_pass)
    VALUES ('admin', 'password');
    
CREATE TABLE user_roles (
  	user_name         VARCHAR(20) NOT NULL,
  	role_name         VARCHAR(20) NOT NULL,
  	primary key (user_name, role_name)
);

INSERT INTO user_roles (user_name, role_name)
    VALUES ('admin', 'ADMIN');
    
CREATE TABLE nutzer
(
	user_id SERIAL NOT NULL PRIMARY KEY,
	nachname VARCHAR(30) NOT NULL,
	vorname VARCHAR(30) NOT NULL,
	username VARCHAR(30) NOT NULL,
	strasse VARCHAR(30),
	hausnummer VARCHAR(6),
	postleitzahl VARCHAR(6),
	ort VARCHAR(30),
	land VARCHAR(30),
	email VARCHAR(30) NOT NULL,
	avatar TEXT
);

CREATE TABLE kategorien
(
	kateg_id SERIAL NOT NULL PRIMARY KEY,
	kat_name VARCHAR(30) NOT NULL,
	icon TEXT
);

CREATE TABLE artikel
(
	artikel_id SERIAL NOT NULL PRIMARY KEY,
	art_name VARCHAR(30) NOT NULL,
	preis NUMERIC(10,2) NOT NULL,
	slots VARCHAR(30) NOT NULL,
	bild TEXT,
	beschreibung TEXT,
	kategorie integer NOT NULL,
	verkauft BOOLEAN NOT NULL
);

CREATE TABLE los
(
	id SERIAL NOT NULL PRIMARY KEY,
	user_id integer NOT NULL,
	artikel_id integer NOT NULL,
	losnr INTEGER NOT NULL,
	zeitstempel TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	gewonnen boolean
);

-- FOREIGN KEYS
ALTER TABLE artikel ADD FOREIGN KEY (kategorie) REFERENCES kategorien(kateg_id);
ALTER TABLE los ADD FOREIGN KEY (user_id) REFERENCES nutzer(user_id);
ALTER TABLE los ADD FOREIGN KEY (artikel_id) REFERENCES artikel(artikel_id);


INSERT INTO nutzer (nachname, vorname, username, strasse, hausnummer, postleitzahl, ort, land, email, avatar)
    VALUES ('Frehner', 'Deny', 'frehde', 'Belmontsrasse', '8', '7000', 'Chur', 'Schweiz', 'defreh@frehde.de', 'none');
    
   
INSERT INTO nutzer (nachname, vorname, username, strasse, hausnummer, postleitzahl, ort, land, email, avatar)
    VALUES ('Hefti', 'Christian', 'chefti', 'Tittwiesentrasse', '42', '7000', 'Chur', 'Schweiz', 'chefti@chef.ti', 'none');

INSERT INTO kategorien (kat_name, icon) 
	VALUES ('Games', 'none');

INSERT INTO kategorien (kat_name, icon) 
	VALUES ('Buecher', 'none');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, verkauft) 
	VALUES ('Fifa 98', '10.0', '8', 'none', 'Viel zu alt, daher gut', '1','false');


