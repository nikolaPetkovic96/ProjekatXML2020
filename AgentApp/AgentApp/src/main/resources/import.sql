--Users
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('test', '$2a$10$786OZQwAuZ.Y8Nw6dm12SeyXW7r/M7sHb6aJZNHerDEjIGt4FlJlS', 'nmaster@gmail.com', 1, 'aktivan','Marko', 'Markovic', '213123124','Muski',NULL, NULL, 22)
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('firma' ,'$2a$10$ThUT1iTXIkCMfPpCfBfC4eEPl.0L.9yAhIiNNqGk7/6tDnInnyYMS', 'sadasd@gmail.com', 3, 'aktivan', NULL, NULL, NULL, NULL, 'Firma 1', '7662313', 23)


--Adresa za usera 1-3
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Ruma', 22400,'Neznanog i znanog junaka', 35, 61)
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Novi Sad',21000,'Deset Jugovica', 5, 62)
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Beograd',11000,'9. Marta', 25, 63)
--Authority
INSERT INTO AUTHORITY(name) VALUES('ROLE_AGENT')

--User_Authority
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (1, 1)
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (2, 1)

-- Test users
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('Darkooo91', 'pass1', 'nmaster@gmail.com', 4, 'aktivan','Darko', 'Darkovic', '213123124','Muski',NULL, NULL, 24)
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('Anna00', 'pass2', 'nmaster@gmail.com', 4, 'aktivan','Ana', 'Anic', '213123124','Zenski',NULL, NULL, 24)
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('PeraCar996', 'pass2', 'nmaster@gmail.com', 4, 'aktivan','Petar', 'Petrovic', '213123124','Zenski',NULL, NULL, 24)


--CommonData (Za KlasaAutomobila) 1 - 3
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za MarkaAutomobila) 4 - 6
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za ModelAutomobila) 7 - 12
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za TipMenjaca) 13 - 15
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za TipGoriva)	16 - 18
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za Cenovnik)	19 - 21
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData  (Za Usera)	22 - 24
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData  (Za Adresu usera)	25 - 27
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--KlasaAutomobila 
INSERT INTO Klasa_Automobila(naziv_klase, common_data_id) VALUES('SUV', 1)
INSERT INTO Klasa_Automobila(naziv_klase, common_data_id) VALUES('Old tajmer', 2)
INSERT INTO Klasa_Automobila(naziv_klase, common_data_id) VALUES('Gradski auto', 3)

--MarkaAutomobila
INSERT INTO Marka_Automobila(naziv_marke, common_data_id) VALUES('Fiat', 4)
INSERT INTO Marka_Automobila(naziv_marke, common_data_id) VALUES('Audi', 5)
INSERT INTO Marka_Automobila(naziv_marke, common_data_id) VALUES('Porsche', 6)

--ModelAutomobila(po dva modela za svaku marku)
INSERT INTO Model_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('500 L', 1, 7)
INSERT INTO Model_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('Punto', 1, 8)
INSERT INTO Model_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('A6', 2, 9)
INSERT INTO Model_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('A8', 2, 10)
INSERT INTO Model_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('911', 3, 11)
INSERT INTO Model_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('Panamera', 3, 12)

--TipMenjaca
INSERT INTO Tip_Menjaca(naziv_menjaca, common_data_id) VALUES('Automatik', 13)
INSERT INTO Tip_Menjaca(naziv_menjaca, common_data_id) VALUES('Sport', 14)
INSERT INTO Tip_Menjaca(naziv_menjaca, common_data_id) VALUES('Manuelni', 15)

--TipGoriva
INSERT INTO Tip_Goriva(naziv_tipa, common_data_id) VALUES('Dizel', 16)
INSERT INTO Tip_Goriva(naziv_tipa, common_data_id) VALUES('Benizn', 17)
INSERT INTO Tip_Goriva(naziv_tipa, common_data_id) VALUES('Bezolovno', 18)


--Cenovnik
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Porodicni paket',2500, 2200, 1200, 10, 25)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Medjugradski cenovnik',3000, 3200, 1400, 20, 26)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Gradski cenovnik',1800, 2000, 800, 50, 27)

-----------------------------------------------------------USER-----------------------------------------------------------------

