--INSERT INTO USERS(username, password,  enabled, last_password_reset_date) VALUES ('user', 'tre',  true, '2017-10-01 21:58:58.508-07')
--INSERT INTO USERS(username, password,  enabled, last_password_reset_date) VALUES ('user2', 'bell', true, '2017-10-01 18:57:58.508-07')
--INSERT INTO USERS(username, password,  enabled, last_password_reset_date) VALUES ('user3', 'bella', true, '2017-10-01 18:57:58.508-07')

--INSERT INTO AUTHORITY(name) VALUES('ROLE_USER')
--INSERT INTO AUTHORITY(name) VALUES('ROLE_ADMIN')
--INSERT INTO AUTHORITY(name) VALUES('ROLE_PACIJENT')

--INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (1, 1)
--INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (2, 2)


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
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Ocenu) 25 - 27
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)


--CommonData (Za Oglas)	28 - 30
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)


--CommonData (Za Poruku) 31 - 33
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)


--CommonData (Za Rezervacije) 34 - 36
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)


--CommonData (Za Automobil)	37 - 39
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Cenovnik)	40 - 42
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Adresu)	43 - 45
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Narudzbenicu)	46 - 48
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Izvestaj)	49 - 51
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Usera)	52 - 54
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

--SlikaVozila
INSERT INTO Slika_Vozila(slika, automobil_id, common_data_id) VALUES(' ', 1, 19)
INSERT INTO Slika_Vozila(slika, automobil_id, common_data_id) VALUES(' ', 2, 20)
INSERT INTO Slika_Vozila(slika, automobil_id, common_data_id) VALUES(' ', 3, 21)

--Automobil
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_aut_id, marka_aut_id, model_aut_id, predj_kilom, ukupna_ocena, tip_menjaca_id, tip_goriva_id, common_data_id) VALUES (1, true, 1, 1, 1, 56000, 4.5, 3, 2, 37)
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_aut_id, marka_aut_id, model_aut_id, predj_kilom, ukupna_ocena, tip_menjaca_id, tip_goriva_id, common_data_id) VALUES (2, true, 2, 2, 3, 6700,   2.5, 1, 1, 38)
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_aut_id, marka_aut_id, model_aut_id, predj_kilom, ukupna_ocena, tip_menjaca_id, tip_goriva_id, common_data_id) VALUES (1, true, 1, 1, 1, 526000,3.6, 2, 3, 39)


--Cenovnik
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Porodicni paket',2500, 2200, 1200, 10, 40)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Medjugradski cenovnik',3000, 3200, 1400, 20, 41)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Gradski cenovnik',1800, 2000, 800, 50, 42)

--Oglas 
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, cenovnik_id, automobil_id, common_data_id) VALUES('2017-10-01 21:58:58','2018-10-02 18:57:58',25000, 1, 1, 28)
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, cenovnik_id, automobil_id, common_data_id) VALUES('2020-11-01 21:58:58','2020-12-02 18:57:58',3000,  2, 2, 29)
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, cenovnik_id, automobil_id, common_data_id) VALUES('2012-10-01 21:58:58','2012-11-02 18:57:58',12000, 3, 3, 30)

--Adresa
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, oglas_id, common_data_id) VALUES('Ruma', 22400,'Neznanog i znanog junaka', 35, 1, 43)
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, oglas_id, common_data_id) VALUES('Novi Sad',21000,'Deset Jugovica', 5, 2, 44)
INSERT INTO Adresa(mesto, postanski_broj, ulica, broj, oglas_id, common_data_id) VALUES('Beograd',11000,'9. Marta', 25, 3, 45)

--Narudzbenica
INSERT INTO Narudzbenica(od_datuma, do_datuma, user_id, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2017-10-01 21:58:58','2018-10-02 18:57:58',1, 1, 1, 1, 46)
INSERT INTO Narudzbenica(od_datuma, do_datuma, user_id, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2017-10-01 21:58:58','2018-10-02 18:57:58',2, 2, 2, 2, 47)
INSERT INTO Narudzbenica(od_datuma, do_datuma, user_id, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2020-10-01 21:58:58','2020-10-02 18:57:58',2, 2, 2, 2, 47)
INSERT INTO Narudzbenica(od_datuma, do_datuma, user_id, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2017-10-01 21:58:58','2018-10-02 18:57:58',3, 3, 3, 3, 48)

--Izvestaj
INSERT INTO Izvestaj(predjena_km, tekst_izvestaja, narudzbenica_id, common_data_id) VALUES(2530,'Neki tekst izvestaja', 1, 49)
INSERT INTO Izvestaj(predjena_km, tekst_izvestaja, narudzbenica_id, common_data_id) VALUES(8500,'Neki tekst izvestaja 2. Neki tekst izvestaja. Neki tekst izvestaja ', 2, 50)
INSERT INTO Izvestaj(predjena_km, tekst_izvestaja, narudzbenica_id, common_data_id) VALUES(4510, 'Neki tekst izvestaja 2. Neki tekst izvestaja. Neki tekst izvestaja ', 3, 51)
--Rezervacija
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id) VALUES(true, 'PENDING', 22000, 34)
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id) VALUES(false,'PENDING', 12000, 35)
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id) VALUES(true, 'PENDING', 8000, 36)

--Komentar
INSERT INTO Komentar(tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Ekstra kola sve pohvale', true, 1, 1, 22)
INSERT INTO Komentar(tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Ekstra naj naj naj kola sve pohvale', true,2, 2, 23)
INSERT INTO Komentar(tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Nisu bas dobra kola, nema pohvale', true,3, 3, 24)

--Ocena 
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(4, 1, 1, 25)
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(5, 2, 2, 26)
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(2, 3, 3, 27)

--Poruka
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je prva poruka.  Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 31)
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je druga poruka. Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 2, 2, 32)
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je treca poruka. Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 3, 3, 33)

--Users
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('NoobMaster69' ,'password123', 'nmaster@gmail.com', 1, 'aktivan','Darko', 'Darkovic', '213123124','Muski',NULL, NULL, 52)
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('username2' ,'password567', 'sardas@gmail.com', 2, 'aktivan','Tanja', 'Tanjic', '766745894','Zenski',NULL, NULL, 53)
INSERT INTO Users(korisnicko_ime, lozinka, email, adresa_id, status, ime, prezime, jmbg, pol, naziv, pib, common_data_id) VALUES ('username23' ,'password890', 'sadasd@gmail.com', 3, 'aktivan', NULL, NULL, NULL, NULL, 'Firma 1', '7662313', 54)

