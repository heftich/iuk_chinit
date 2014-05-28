DROP TABLE IF EXISTS los;
DROP TABLE IF EXISTS artikel;
DROP TABLE IF EXISTS kategorien;
DROP TABLE IF EXISTS nutzer;
DROP TABLE IF EXISTS nutzerrechte;



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
	password VARCHAR(40) NOT NULL
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
	user_id integer,
	artikel_id integer NOT NULL,
	losnr INTEGER NOT NULL,
	zeitstempel TIMESTAMP WITHOUT TIME ZONE,
	gewonnen boolean,
	verkauft boolean
);

CREATE TABLE nutzerrechte
(
	username VARCHAR(20) NOT NULL,
	role_name VARCHAR(20) NOT NULL,
	CONSTRAINT user_roles_pkey PRIMARY KEY(username, role_name)
);


-- FOREIGN KEYS
ALTER TABLE artikel ADD FOREIGN KEY (kategorie) REFERENCES kategorien(kateg_id);
ALTER TABLE los ADD FOREIGN KEY (user_id) REFERENCES nutzer(user_id);
ALTER TABLE los ADD FOREIGN KEY (artikel_id) REFERENCES artikel(artikel_id);


INSERT INTO nutzer (nachname, vorname, username, strasse, hausnummer, postleitzahl, ort, land, email, avatar, password)
    VALUES ('Frehner', 'Deny', 'frehde', 'Belmontsrasse', '8', '7000', 'Chur', 'Schweiz', 'defreh@frehde.de', 'none', 'frehde');
       
INSERT INTO nutzer (nachname, vorname, username, strasse, hausnummer, postleitzahl, ort, land, email, avatar, password)
    VALUES ('Hefti', 'Christian', 'chefti', 'Tittwiesentrasse', '42', '7000', 'Chur', 'Schweiz', 'chefti@chef.ti', 'none', 'chefti');

INSERT INTO nutzerrechte (username, role_name)
	VALUES ('frehde', 'ADMIN');

INSERT INTO nutzerrechte (username, role_name)
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
	VALUES ('Fifa 2012', '10.0', '8', '../resources/img/fifa12.jpg', 'Fussballspiel', '1','0');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('1', '1', 'false', 'false');

INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('1', '2', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('1', '3', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('1', '4', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('1', '5', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('1', '6', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('1', '7', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('1', '8', 'false', 'false');

INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('NHL 2014', '100.0', '8', '../resources/img/nhl14.jpg', 'Eishockeyspiel', '1','0');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('2', '1', 'false', 'false');

INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('2', '2', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('2', '3', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('2', '4', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('2', '5', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('2', '6', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('2', '7', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('2', '8', 'false', 'false');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Harry Potter', '11.8', '8', '../resources/img/Harrypotter.jpg', 'Fantasy', '2','0');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('3', '1', 'false', 'false');

INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('3', '2', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('3', '3', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('3', '4', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('3', '5', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('3', '6', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('3', '7', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('3', '8', 'false', 'false');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Feuchtgebiete', '14.9', '8', '../resources/img/feuchtgebiete18.png', 'Biographie', '2','0');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('4', '1', 'false', 'false');

INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('4', '2', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('4', '3', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('4', '4', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('4', '5', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('4', '6', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('4', '7', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('4', '8', 'false', 'false');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Angry Birds', '3.2', '8', '../resources/img/angrybirds.png', 'Vögel und Schweine', '3','0');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('5', '1', 'false', 'false');

INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('5', '2', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('5', '3', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('5', '4', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('5', '5', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('5', '6', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('5', '7', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('5', '8', 'false', 'false');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Instagram', '2.5', '8', '../resources/img/instagram.png', 'Social Media', '3','0');

INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('6', '1', 'false', 'false');

INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('6', '2', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('6', '3', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('6', '4', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('6', '5', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('6', '6', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('6', '7', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('6', '8', 'false', 'false');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Pulp Fiction', '15', '8', '../resources/img/pulpfiction.jpg', 'Actionfilm', '4','0');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('7', '1', 'false', 'false');

INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('7', '2', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('7', '3', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('7', '4', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('7', '5', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('7', '6', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('7', '7', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('7', '8', 'false', 'false');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Iron Man 2', '19', '8', '../resources/img/ironman.png', 'Superheldenfilm', '4','0');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('8', '1', 'false', 'false');

INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('8', '2', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('8', '3', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('8', '4', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('8', '5', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('8', '6', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('8', '7', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('8', '8', 'false', 'false');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('Blick', '2.8', '8', '../resources/img/blick.jpg', 'Boulevardzeitung', '5','0');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('9', '1', 'false', 'false');

INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('9', '2', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('9', '3', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('9', '4', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('9', '5', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('9', '6', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('9', '7', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('9', '8', 'false', 'false');
	
INSERT INTO artikel (art_name, preis, slots, bild, beschreibung, kategorie, status) 
	VALUES ('20 Minuten', '1.8', '8', '../resources/img/20min.png', 'Schundnachrichten', '5','0');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('10', '1', 'false', 'false');

INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('10', '2', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('10', '3', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('10', '4', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('10', '5', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('10', '6', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('10', '7', 'false', 'false');
	
INSERT INTO los (artikel_id, losnr, gewonnen, verkauft)
	VALUES ('10', '8', 'false', 'false');





