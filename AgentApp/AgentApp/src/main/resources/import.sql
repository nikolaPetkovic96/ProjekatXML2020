--Users
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id,allowed_to_commend,allowed_to_message,allowed_to_make_reserv) VALUES ('test', '$2a$10$786OZQwAuZ.Y8Nw6dm12SeyXW7r/M7sHb6aJZNHerDEjIGt4FlJlS', 'nmaster@gmail.com', 1, 'aktivan','Marko', 'Markovic', '213123124','Muski',NULL, NULL, 22, true, true, true)
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id,allowed_to_commend,allowed_to_message,allowed_to_make_reserv) VALUES ('firma' ,'$2a$10$ThUT1iTXIkCMfPpCfBfC4eEPl.0L.9yAhIiNNqGk7/6tDnInnyYMS', 'sadasd@gmail.com', 3, 'aktivan', NULL, NULL, NULL, NULL, 'Firma 1', '7662313', 23, true, true, true)


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
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id,allowed_to_commend,allowed_to_message,allowed_to_make_reserv) VALUES ('Darkooo91', 'pass1', 'nmaster@gmail.com', 4, 'aktivan','Darko', 'Darkovic', '213123124','Muski',NULL, NULL, 24, true, true,true)
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id,allowed_to_commend,allowed_to_message,allowed_to_make_reserv) VALUES ('Anna00', 'pass2', 'blage500@gmail.com', 4, 'aktivan','Ana', 'Anic', '213123124','Zenski',NULL, NULL, 24, true, true, true)
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id,allowed_to_commend,allowed_to_message,allowed_to_make_reserv) VALUES ('PeraCar996', 'pass2', 'nmaster@gmail.com', 4, 'aktivan','Petar', 'Petrovic', '213123124','Zenski',NULL, NULL, 24, true, true, true)


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
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',1)

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
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Porodicni paket',2500, 2200, 1200, 10, 19)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Medjugradski cenovnik',3000, 3200, 1400, 20, 20)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Gradski cenovnik',1800, 2000, 800, 50, 21)

-----------------------------------------------------------IZVESTAJ-----------------------------------------------------------------
--Automobil 28
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',1)
--Oglas 29
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-25 21:58:58', null, 1) --test
--Narudbenica 30
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, 4)  -- Anna00 
--Rezervacija 31
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, 4) -- Anna00

--Narudbenica 32
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, 4)  -- Anna00 
--Rezervacija 33
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, 4) -- Anna00
--Narudbenica 34
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, 4)  -- Anna00 


INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id) VALUES('2021-02-01 21:58:58','2021-02-25 18:57:58', 12000, 3, 3, 1, 29)
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2021-02-01 21:58:58','2021-02-05 18:57:58', 1, 1, 1, 30)-- jos traje  -- Anna00  Anna00 dve odvojene rezerv (4,5)
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id) VALUES(false,'PAID', 55000, 31) -- istekao 

INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2021-02-10 21:58:58','2021-02-12 18:57:58', 1, 2, 1, 32)-- jos traje  -- Anna00  Anna00 dve odvojene rezerv (4,5)
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2021-02-17 21:58:58','2021-02-20 18:57:58', 1, 2, 1, 33)-- jos traje  -- Anna00  Anna00 dve odvojene rezerv (4,5)
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id) VALUES(false,'PENDING', 10000, 34) -- istekao 


--Oglas 35
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-25 21:58:58', null, 1) --test
--Narudbenica 36
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, 4)  -- Anna00 
--Rezervacija 37
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, 4) -- Anna00

INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id) VALUES('2021-03-01 21:58:58','2021-03-31 18:57:58', 12000, 3, 3, 1, 35)
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2021-02-01 21:58:58','2021-02-05 18:57:58', 2, 3, 1, 36)-- jos traje  -- Anna00  Anna00 dve odvojene rezerv (4,5)
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id) VALUES(false,'PAID', 55000, 37) -- istekao 

--INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_aut_id, marka_aut_id, model_aut_id, predj_kilom, ukupna_ocena, tip_menjaca_id, tip_goriva_id, common_data_id) VALUES (1, true, 1, 1, 1, 56000,  4.5, 3, 2, 28)
--Rezervacija 37
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, 4) -- Anna00
