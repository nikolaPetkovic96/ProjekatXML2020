--INSERT INTO USERS(username, password,  enabled, last_password_reset_date) VALUES ('user', 'tre',  true, '2017-10-01 21:58:58.508-07')
--INSERT INTO USERS(username, password,  enabled, last_password_reset_date) VALUES ('user2', 'bell', true, '2017-10-01 18:57:58.508-07')
--INSERT INTO USERS(username, password,  enabled, last_password_reset_date) VALUES ('user3', 'bella', true, '2017-10-01 18:57:58.508-07')

--INSERT INTO AUTHORITY(name) VALUES('ROLE_USER')
--INSERT INTO AUTHORITY(name) VALUES('ROLE_ADMIN')
--INSERT INTO AUTHORITY(name) VALUES('ROLE_PACIJENT')

--INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (1, 1)
--INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (2, 2)


-----------------------------------------------------------USER-----------------------------------------------------------------

--CommonData (Za TKlasaAutomobila)	
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za TMarkaAutomobila)	
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za TModelAutomobila)	
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za TTipMenjaca)	
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za TTipGoriva)	
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za TSlikaVozila)	
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za Komentar)	
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Ocenu)	
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)


--CommonData (Za Oglas)	
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)


--CommonData (Za Poruku)	
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)


--CommonData (Za Rezervacije)	
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--TAdresa
INSERT INTO TAdresa(mesto, postanski_broj, ulica, broj, common_data_id ) VALUES('Ruma', 22400,'Neznanog i znanog junaka', 35, 1)
INSERT INTO TAdresa(mesto, postanski_broj, ulica, broj, common_data_id) VALUES('Novi Sad',21000,'Deset Jugovica', 5, 1)
INSERT INTO TAdresa(mesto, postanski_broj, ulica, broj, common_data_id)  VALUES('Beograd',11000,'9. Marta', 25, 1)

--TKlasaAutomobila
INSERT INTO TKlasa_Automobila(naziv_klase, common_data_id) VALUES('SUV', 1)
INSERT INTO TKlasa_Automobila(naziv_klase, common_data_id) VALUES('Old tajmer', 2)
INSERT INTO TKlasa_Automobila(naziv_klase, common_data_id) VALUES('Gradski auto', 3)

--TMarkaAutomobila
INSERT INTO TMarka_Automobila(naziv_marke, common_data_id) VALUES('Fiat', 4)
INSERT INTO TMarka_Automobila(naziv_marke, common_data_id) VALUES('Audi', 5)
INSERT INTO TMarka_Automobila(naziv_marke, common_data_id) VALUES('Porsche', 6)

--TModelAutomobila(po dva modela za svaku marku)
INSERT INTO TModel_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('500 L', 1, 7)
INSERT INTO TModel_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('Punto', 1, 8)
INSERT INTO TModel_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('A6', 2, 9)
INSERT INTO TModel_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('A8', 2, 10)
INSERT INTO TModel_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('911', 3, 11)
INSERT INTO TModel_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('Panamera', 3, 12)

--TTipMenjaca
INSERT INTO TTip_Menjaca(naziv_menjaca, common_data_id) VALUES('Automatik', 13)
INSERT INTO TTip_Menjaca(naziv_menjaca, common_data_id) VALUES('Sport', 14)
INSERT INTO TTip_Menjaca(naziv_menjaca, common_data_id) VALUES('Manuelni', 15)

--TTipGoriva
INSERT INTO TTip_Goriva(naziv_tipa, common_data_id) VALUES('Dizel', 16)
INSERT INTO TTip_Goriva(naziv_tipa, common_data_id) VALUES('Benizn', 17)
INSERT INTO TTip_Goriva(naziv_tipa, common_data_id) VALUES('Bezolovno', 18)

--TSlikaVozila
--INSERT INTO TTip_Goriva(slika, automobil_id, common_data_id) VALUES("B@6c89db9a", 1, 19)
--INSERT INTO TTip_Goriva(slika, automobil_id, common_data_id) VALUES(' ', 2, 20)
--INSERT INTO TTip_Goriva(slika, automobil_id, common_data_id) VALUES(' ', 3, 21)

--Automobil
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id,  predj_kilom, tip_menjaca_id, vrsta_goriva_id, common_data_id) VALUES (1, true, 1, 1, 1,  56000, 3, 2,1)
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id,  predj_kilom, tip_menjaca_id, vrsta_goriva_id, common_data_id) VALUES (2, true, 2, 2, 3,  6700, 1, 1,1)
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id,  predj_kilom, tip_menjaca_id, vrsta_goriva_id, common_data_id) VALUES (1, true, 1, 1, 1,  526000, 2, 3,1)

--Administrator
INSERT INTO Administrator(ime, prezime, jmbg) VALUES('Petar', 'Petrovic', '213123124')
INSERT INTO Administrator(ime, prezime, jmbg) VALUES('Marko', 'Markovic', '766745894')
INSERT INTO Administrator(ime, prezime, jmbg) VALUES('Ana', 'Anica', '6969696968')

--Firma i Agent
INSERT INTO Firma(ime, prezime, jmbg, naziv, pib) VALUES('Darko', 'Darkovic', '213123124',null, null)
INSERT INTO Firma(ime, prezime, jmbg, naziv, pib) VALUES('Tanja', 'Tanjic', '766745894',null, null) 
INSERT INTO Firma(ime, prezime, jmbg, naziv, pib) VALUES(null, null, null, 'Firma 1', '7662313')

--Registrovani korisnik
INSERT INTO Registrovani_korisnik(ime, prezime, jmbg) VALUES('Reg1', 'Korisnikovic', '213123124')
INSERT INTO Registrovani_korisnik(ime, prezime, jmbg) VALUES('Reg2', 'Korisnikovic', '766745894') 
INSERT INTO Registrovani_korisnik(ime, prezime, jmbg) VALUES('Reg3', 'Korisnikovic', '766231321')

--TUser
INSERT INTO TUser(korisnicko_ime, lozinka, email, adresa_id, status) VALUES ('NoobMaster69' ,'password123', 'nmaster@gmail.com', 1, 'aktivan')
INSERT INTO TUser(korisnicko_ime, lozinka, email, adresa_id, status) VALUES ('username2' ,'password567', 'sardas@gmail.com', 2, 'aktivan')
INSERT INTO TUser(korisnicko_ime, lozinka, email, adresa_id, status) VALUES ('username23' ,'password890', 'sadasd@gmail.com', 3, 'aktivan')

--Cenovnik
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_km, popust30) VALUES('Porodicni paket',2500, 2200, 1200,700)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_km, popust30) VALUES('Medjugradski cenovnik',3000, 3200, 1400,900)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_km, popust30) VALUES('Gradski cenovnik',1800, 2000, 800,400)

--Komentar
INSERT INTO Komentar( tekst_komentara, odobren, automobil_id, rezervacija_id, common_data_id) VALUES('Ekstra kola sve pohvale', true, 1,1, 22)
INSERT INTO Komentar( tekst_komentara, odobren, automobil_id, rezervacija_id, common_data_id) VALUES('Ekstra naj naj naj kola sve pohvale', true, 2,2, 23)
INSERT INTO Komentar( tekst_komentara, odobren, automobil_id, rezervacija_id, common_data_id) VALUES('Nisu bas dobra kola, nema pohvale', true, 3,3, 24)

--Ocena 
INSERT INTO Ocena(vredn_ocene, automobil_id, rezervacija_id, common_data_id) VALUES(4, 1, 1, 25)
INSERT INTO Ocena(vredn_ocene, automobil_id, rezervacija_id, common_data_id) VALUES(5, 2, 2, 26)
INSERT INTO Ocena(vredn_ocene, automobil_id, rezervacija_id, common_data_id) VALUES(2, 3, 3, 27)

--Oglas 
INSERT INTO Oglas(od_datuma, do_datuma, cenovnik_id, automobil_id, planirana_km,common_data_id) VALUES('2017-10-01 21:58:58','2018-10-02 18:57:58', 1, 1, 100, 28)
INSERT INTO Oglas(od_datuma, do_datuma, cenovnik_id, automobil_id, planirana_km,common_data_id) VALUES('2020-11-01 21:58:58','2020-12-02 18:57:58', 2, 2, 250, 29)
INSERT INTO Oglas(od_datuma, do_datuma, cenovnik_id, automobil_id, planirana_km,common_data_id) VALUES('2012-10-01 21:58:58','2012-11-02 18:57:58', 3, 3, 12, 30)

--Poruka
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je prva poruka.  Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 31)
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je druga poruka. Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 2, 2, 32)
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je treca poruka. Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 3, 3, 33)


--Rezervacija
INSERT INTO Rezervacija(bundle, do_datuma, od_datuma, status_rezerv, ukupna_cena, common_data_id) VALUES(true,'2021-10-01 21:58:58','2021-10-02 18:57:58', 'PENDING', 22000, 34)
INSERT INTO Rezervacija(bundle, do_datuma, od_datuma, status_rezerv, ukupna_cena, common_data_id) VALUES(false,'2022-10-01 21:58:58','2022-10-02 18:57:58', 'PENDING', 12000, 35)
INSERT INTO Rezervacija(bundle, do_datuma, od_datuma, status_rezerv, ukupna_cena, common_data_id) VALUES(true,'2023-10-01 21:58:58','2023-10-02 18:57:58', 'PENDING', 8000, 36)

--INSERT INTO rezervacije_oglasi(rezervacija_id,oglas_id) VALUES (1,1) bespotrebno jer sada razervacija sadrzi listu narduzbenica, 
--INSERT INTO rezervacije_oglasi(rezervacija_id,oglas_id) VALUES (1,2) a svaka narudzbenica je u vezi sa samo jednim oglasom i samo jednom rezervacijom
--INSERT INTO rezervacije_oglasi(rezervacija_id,oglas_id) VALUES (2,1) -


--Izvestaj
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

INSERT INTO Izvestaj(narudzbenica_id,predjena_km,poruka,common_data_id) VALUES(1,10,'',37)
INSERT INTO Izvestaj(narudzbenica_id,predjena_km,poruka,common_data_id) VALUES(2,10,'sdfsdf',38)
INSERT INTO Izvestaj(narudzbenica_id,predjena_km,poruka,common_data_id) VALUES(3,10,'sdfsdfsdf',39)

--Narduzbenica
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

INSERT INTO Narudzbenica(od_datuma,do_datuma,user_id,oglas_id,rez_id,common_data_id) VALUES ('2017-10-01 21:58:58','2017-10-03 21:58:58',1,1,1,40)
INSERT INTO Narudzbenica(od_datuma,do_datuma,user_id,oglas_id,rez_id,common_data_id) VALUES ('2017-10-01 21:58:58','2017-10-03 21:58:58',1,2,1,41)
INSERT INTO Narudzbenica(od_datuma,do_datuma,user_id,oglas_id,rez_id,common_data_id) VALUES ('2017-10-01 21:58:58','2017-10-03 21:58:58',1,3,2,42)

