--Users
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('test', '$2a$10$786OZQwAuZ.Y8Nw6dm12SeyXW7r/M7sHb6aJZNHerDEjIGt4FlJlS', 'nmaster@gmail.com', 4, 'aktivan','Marko', 'Markovic', '213123124','Muski',NULL, NULL, 59)
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('firma' ,'$2a$10$ThUT1iTXIkCMfPpCfBfC4eEPl.0L.9yAhIiNNqGk7/6tDnInnyYMS', 'sadasd@gmail.com', 6, 'aktivan', NULL, NULL, NULL, NULL, 'Firma 1', '7662313', 60)

--Authority
INSERT INTO AUTHORITY(name) VALUES('ROLE_AGENT')

--User_Authority
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (1, 1)
INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (2, 1)

-- Test users
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('Darkooo91', 'pass1', 'nmaster@gmail.com', 4, 'aktivan','Darko', 'Darkovic', '213123124','Muski',NULL, NULL, 52)
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('Anna00', 'pass2', 'nmaster@gmail.com', 4, 'aktivan','Ana', 'Anic', '213123124','Zenski',NULL, NULL, 52)
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('PeraCar996', 'pass2', 'nmaster@gmail.com', 4, 'aktivan','Petar', 'Petrovic', '213123124','Zenski',NULL, NULL, 52)

-----------------------------------------------------------USER-----------------------------------------------------------------

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

--CommonData (Za SlikaVozila) 19 - 21
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za Komentar) 22 - 24
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',3)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',5)

--CommonData (Za Ocenu) 25 - 27
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',3)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',5)

--CommonData (Za Oglas)	28 - 33
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za Poruku) 34 - 36
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',3)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)

--CommonData (Za Rezervacije) 37 - 39
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',3)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Automobil)	40 - 42
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za Cenovnik)	43 - 45
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Adresu oglasa)	46 - 51 (user id adrese je isti kao i user id oglasa za koji je vezana adresa)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za Narudzbenicu)	52 - 55
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Izvestaj)	56 - 58
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Usera)	59 - 60
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData  (Za Adresu usera)	61 - 63
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData  (Za Automobil 4) 64
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)
--CommonData  (Za Poruku 4) 65
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-04 21:58:58','2020-07-04 18:57:58',1)

--CommonData  (Za 3 nove rezervacije ) 66 - 68
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-04 21:58:58','2020-07-04 18:57:58',4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-04 21:58:58','2020-07-04 18:57:58',4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-04 21:58:58','2020-07-04 18:57:58',5)

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

--SlikaVozila
INSERT INTO Slika_Vozila(slika, automobil_id, common_data_id) VALUES(' ', 1, 19)
INSERT INTO Slika_Vozila(slika, automobil_id, common_data_id) VALUES(' ', 2, 20)
INSERT INTO Slika_Vozila(slika, automobil_id, common_data_id) VALUES(' ', 3, 21)

--Automobil
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_aut_id, marka_aut_id, model_aut_id, predj_kilom, ukupna_ocena, tip_menjaca_id, tip_goriva_id, common_data_id) VALUES (1, true, 1, 1, 1, 56000,  4.5, 3, 2, 40)
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_aut_id, marka_aut_id, model_aut_id, predj_kilom, ukupna_ocena, tip_menjaca_id, tip_goriva_id, common_data_id) VALUES (2, true, 2, 2, 3, 6700,   2.5, 1, 1, 41)
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_aut_id, marka_aut_id, model_aut_id, predj_kilom, ukupna_ocena, tip_menjaca_id, tip_goriva_id, common_data_id) VALUES (1, true, 3, 3, 5, 526000, 3.6, 2, 3, 42)
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_aut_id, marka_aut_id, model_aut_id, predj_kilom, ukupna_ocena, tip_menjaca_id, tip_goriva_id, common_data_id) VALUES (2, false,3, 3, 6, 10000,  4.6, 2, 3, 64)
--Cenovnik
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Porodicni paket',2500, 2200, 1200, 10, 43)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Medjugradski cenovnik',3000, 3200, 1400, 20, 44)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Gradski cenovnik',1800, 2000, 800, 50, 45)

--Oglas (Mogu se obrisati 4,5,6 iz guia)
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id) VALUES('2021-01-01 21:58:58','2021-01-25 18:57:58',25000,1, 1, 1, 46) --reprezentativan
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id) VALUES('2020-11-01 21:58:58','2020-12-02 18:57:58',3000, 2, 2, 2, 47)
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id) VALUES('2020-12-01 21:58:58','2020-12-22 18:57:58',12000,3, 3, 3, 48)
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id) VALUES('2020-12-09 21:58:58','2018-12-18 18:57:58',16500,4, 1, 1, 49)
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id) VALUES('2020-12-01 21:58:58','2020-12-31 18:57:58',4500, 5, 2, 2, 50)
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id) VALUES('2020-12-10 21:58:58','2012-12-20 18:57:58',10500,6, 3, 3, 51)

--Adresa za oglas 1-3
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Ruma', 22400,'Neznanog i znanog junaka', 35, 43)
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Novi Sad',21000,'Deset Jugovica', 5, 44)
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Beograd',11000,'9. Marta', 25, 45)
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Ruma', 22400,'Bulevar oslob', 35, 44)
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Novi Sad',21000,'Kosovskih heroja', 5, 45)
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Beograd',11000,'8. Marta', 25, 46)

--Adresa za usera 4-6
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Ruma', 22400,'Neznanog i znanog junaka', 35, 61)
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Novi Sad',21000,'Deset Jugovica', 5, 62)
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Beograd',11000,'9. Marta', 25, 63)

--Narudzbenica	user_id preuzet iz common data u trenutku u kojem se kreirala i rezerivacija , a agent_id je agent koji je kreirao oglas koji pripada narudzbenici  
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2021-01-05 21:58:58','2021-01-10 18:57:58', 1, 1, 1, 52)
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2017-10-01 21:58:58','2018-10-02 18:57:58', 2, 2, 2, 53)
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2020-10-01 21:58:58','2020-10-02 18:57:58', 2, 2, 2, 54)
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2021-01-12 21:58:58','2021-01-18 18:57:58', 1, 1, 1, 55)

--Izvestaj2
INSERT INTO Izvestaj(predjena_km, tekst_izvestaja, narudzbenica_id, common_data_id) VALUES(2530,'Neki tekst izvestaja', 1, 56)
INSERT INTO Izvestaj(predjena_km, tekst_izvestaja, narudzbenica_id, common_data_id) VALUES(8500,'Neki tekst izvestaja 2. Neki tekst izvestaja. Neki tekst izvestaja ', 2, 57)
INSERT INTO Izvestaj(predjena_km, tekst_izvestaja, narudzbenica_id, common_data_id) VALUES(4510, 'Neki tekst izvestaja 2. Neki tekst izvestaja. Neki tekst izvestaja ', 3, 58)

--Rezervacija
--INSERT INTO Rezervacija(bundle, status_rezerv, napomena_rezerv, ukupna_cena, common_data_id) VALUES(true, 'PENDING','Sve super' 22000, 37)
INSERT INTO Rezervacija(bundle, status_rezerv,  ukupna_cena, common_data_id) VALUES(true, 'PENDING', 22000, 37)
INSERT INTO Rezervacija(bundle, status_rezerv,  ukupna_cena, common_data_id) VALUES(false,'PENDING', 12000, 38)
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id) VALUES(true, 'PENDING', 8000, 39)


--CommonData  (Za 3 nove rezervacije ) 66 - 68							datum kreiranja rezrvacije isti kao i narudzbenice
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, 4) -- Anna00
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, 4) -- Anna00
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, 5) -- PeraCar996

-- 3 Nove rezervacije koje su u stanju paid, od kojih su 2 istekle uspesno a jedna jos traje
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id) VALUES(false,'RESERVED', 44000, 66) -- jos traje
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id) VALUES(false,'PAID', 55000, 67) -- istekao 
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id) VALUES(true, 'PAID', 66000, 68) -- istekao


--CommonData  (Za 4 nove narudzb isti id kao kod rezerv sa kojom su povezani) 69 - 72
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, 4)  -- Anna00  Anna00 dve odvojene rezerv (4,5)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, 4)  -- Anna00
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, 5)  -- PeraCar996  Jedna rezrv ali je bundle (6)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, 5)  -- PeraCar996
--Narudzbenice za rezervacije 4 nove jer je 3. rezerv budnle;
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2020-12-10 21:58:58','2020-12-22 18:57:58', 7, 4, 1, 69)-- jos traje  -- Anna00  Anna00 dve odvojene rezerv (4,5)
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2020-12-02 21:58:58','2020-12-08 18:57:58', 7, 5, 1, 70)-- istekao    -- Anna00  Anna00 dve odvojene rezerv (4,5)
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2020-12-10 21:58:58','2020-12-15 18:57:58', 8, 6, 1, 71)-- istekao    -- PeraCar996  Jedna rezrv ali je bundle (6)
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2020-12-10 21:58:58','2020-12-15 18:57:58', 9, 6, 1, 72)-- istekao    -- PeraCar996  Jedna rezrv ali je bundle (6)


--CommonData  (Za 3 nova oglasa korisnik_id = idAgenta iz narudzbenice) 73 - 75
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-25 21:58:58', null, 1) --test
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-23 21:58:58', null, 1) --test
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-01 21:58:58', null, 1) --test

 -- Oglas 7 - 9
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id) VALUES('2020-12-01 21:58:58','2020-12-31 18:57:58', 12000, 3, 3, 1, 73)
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id) VALUES('2020-12-01 21:58:58','2020-12-31 18:57:58', 16500, 4, 1, 2, 74)
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id) VALUES('2020-12-01 21:58:58','2020-12-31 18:57:58', 10000, 5, 2, 3, 75)


--Komentar
INSERT INTO Komentar(tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Ekstra kola sve pohvale', true, 1, 1, 22)
INSERT INTO Komentar(tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Ekstra naj naj naj kola sve pohvale', true,2, 2, 23)
INSERT INTO Komentar(tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Nisu bas dobra kola, nema pohvale', true,3, 3, 24)

--CommonData  (Za 2 nova komentara) 76 - 77
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, 4)  -- Anna00 
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, 5)  -- PeraCar996

INSERT INTO Komentar(tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Od Anna00 komentar neki firma agentu ocena 5! ', true, 3, 3, 76) --za porse 911
INSERT INTO Komentar(tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Od PeraCar996 Komentar neki firma agentu ocena 4', true,3, 3, 77) --za porse 911


--Ocena
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(4, 1, 1, 25)
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(5, 2, 2, 26)
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(2, 3, 3, 27)

--Poruka
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je prva poruka usera.  Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 34)
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je druga poruka usera. Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 35)
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je Prva poruka moja. Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 36)
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je druga poruka moja.  Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 65)
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je druga poruka. Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 2, 2, 35)
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je treca poruka. Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 3, 3, 36)
