DROP TABLE IF EXISTS users; 
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS los;
DROP TABLE IF EXISTS artikel;
DROP TABLE IF EXISTS kategorien;
DROP TABLE IF EXISTS nutzer;


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
	avatar TEXT,
	passwort VARCHAR(40) NOT NULL
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
	status integer NOT NULL
);

CREATE TABLE los
(
	id SERIAL NOT NULL PRIMARY KEY,
	user_id integer NOT NULL,
	artikel_id integer NOT NULL,
	losnr INTEGER NOT NULL,
	zeitstempel TIMESTAMP WITHOUT TIME ZONE,
	gewonnen boolean
);

-- FOREIGN KEYS
ALTER TABLE artikel ADD FOREIGN KEY (kategorie) REFERENCES kategorien(kateg_id);
ALTER TABLE los ADD FOREIGN KEY (user_id) REFERENCES nutzer(user_id);
ALTER TABLE los ADD FOREIGN KEY (artikel_id) REFERENCES artikel(artikel_id);


INSERT INTO nutzer (nachname, vorname, username, strasse, hausnummer, postleitzahl, ort, land, email, avatar, passwort)
    VALUES ('Frehner', 'Deny', 'frehde', 'Belmontsrasse', '8', '7000', 'Chur', 'Schweiz', 'defreh@frehde.de', 'none', 'frehde');
       
INSERT INTO nutzer (nachname, vorname, username, strasse, hausnummer, postleitzahl, ort, land, email, avatar, passwort)
    VALUES ('Hefti', 'Christian', 'chefti', 'Tittwiesentrasse', '42', '7000', 'Chur', 'Schweiz', 'chefti@chef.ti', 'none', 'chefti');

INSERT INTO nutzerrechte (user_name, role_name)
    VALUES ('frehde', 'ADMIN');
    
INSERT INTO nutzerrechte (user_name, role_name)
    VALUES ('chefti', 'ADMIN');

INSERT INTO kategorien (kat_name, icon) 
	VALUES ('Games', 'none');

INSERT INTO kategorien (kat_name, icon) 
	VALUES ('Books', 'none');
	
INSERT INTO kategorien (kat_name, icon) 
	VALUES ('Apps', 'none');
	
INSERT INTO kategorien (kat_name, icon) 
	VALUES ('Movies', 'none');
	
INSERT INTO kategorien (kat_name, icon) 
	VALUES ('Newspaper', 'none');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Fifa 98', '10.0', '8', 'none', 'Fussballspiel', '1','0');

INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('NHL 2014', '100.0', '8', 'none', 'Eishockeyspiel', '1','0');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Harry Potter', '11.8', '8', 'none', 'Fantasy', '2','0');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Feuchtgebiete', '14.9', '8', 'none', 'Biographie', '2','0');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Angry Birds', '3.2', '8', 'none', 'Vögel und Schweine', '3','0');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Instagram', '2.5', '8', 'none', 'Social Media', '3','0');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Pulp Fiction', '15', '8', 'none', 'Actionfilm', '4','0');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Iron Man 2', '19', '8', 'none', 'Superheldenfilm', '4','0');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Blick', '2.8', '8', 'none', 'Boulevardzeitung', '5','0');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Suedostschweiz', '1.8', '8', 'none', 'Bündner Nachrichten', '5','0');





