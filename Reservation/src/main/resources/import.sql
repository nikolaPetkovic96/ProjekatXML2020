---------------------------------------------------REZERVACIJA BAZA #2-------------------------------------------------
--
----CommonData (Za TKlasaAutomobila)	1-3
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)
--
----CommonData (Za TMarkaAutomobila)	4-6
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)
--
----CommonData (Za TModelAutomobila)	7-12
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)
--
----CommonData (Za TTipMenjaca)	13-15
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)
--
----CommonData (Za TTipGoriva)	16-18
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)
--
----CommonData (Za Automobile)	19-24
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-5) --pripada BestUser
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5) --pripada BestUser
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-2)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-5) --pripada BestUser
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5) --pripada BestUser
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-3)
--
----TKlasaAutomobila
--INSERT INTO TKlasa_Automobila(naziv_klase, common_data_id) VALUES('SUV', 1)
--INSERT INTO TKlasa_Automobila(naziv_klase, common_data_id) VALUES('Old tajmer', 2)
--INSERT INTO TKlasa_Automobila(naziv_klase, common_data_id) VALUES('Gradski auto', 3)
--
----TMarkaAutomobila
--INSERT INTO TMarka_Automobila(naziv_marke, common_data_id) VALUES('Fiat', 4)
--INSERT INTO TMarka_Automobila(naziv_marke, common_data_id) VALUES('Audi', 5)
--INSERT INTO TMarka_Automobila(naziv_marke, common_data_id) VALUES('Porsche', 6)
--
----TModelAutomobila(po dva modela za svaku marku)
--INSERT INTO TModel_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('500 L', 1, 7)
--INSERT INTO TModel_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('Punto', 1, 8)
--INSERT INTO TModel_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('A6', 2, 9)
--INSERT INTO TModel_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('A8', 2, 10)
--INSERT INTO TModel_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('911', 3, 11)
--INSERT INTO TModel_Automobila(naziv_modela, marka_automobila_id, common_data_id) VALUES('Panamera', 3, 12)
--
----TTipMenjaca
--INSERT INTO TTip_Menjaca(naziv_menjaca, common_data_id) VALUES('Automatik', 13)
--INSERT INTO TTip_Menjaca(naziv_menjaca, common_data_id) VALUES('Sport', 14)
--INSERT INTO TTip_Menjaca(naziv_menjaca, common_data_id) VALUES('Manuelni', 15)
--
----TTipGoriva
--INSERT INTO TTip_Goriva(naziv_tipa, common_data_id) VALUES('Dizel', 16)
--INSERT INTO TTip_Goriva(naziv_tipa, common_data_id) VALUES('Benizn', 17)
--INSERT INTO TTip_Goriva(naziv_tipa, common_data_id) VALUES('Bezolovno', 18)
--
----Automobil
----INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (1, true, 1, 1, 1, 56000, 3,1, 3.8, 19)
----INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (2, true, 2, 1, 2, 6700, 1, 2, 4.5, 20)
----INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (1, true, 3, 2, 3, 526000, 2,1, 3.6, 21)
----INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (2, true, 1, 2, 4, 56000, 3,1, 3.8, 22)
----INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (0, true, 2, 3, 5, 6700, 1,2, 4.5, 23)
----INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (4, true, 3, 3, 6, 86000, 2,1, 3.6, 24)
--
--------------------------------------------------------OGLAS SERVIS------------------------------------------------------
--
----CommonData (Za Cenovnik)	25 - 27
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-5)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-3)
--
--
----CommonData (Za Oglase)	28 - 33
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-5) --pripada BestUser
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5) --pripada BestUser
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-2)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-5) --pripada BestUser
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5) --pripada BestUser
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-3)
--
----CommonData (Za Narudzbenicu)	34 - 35
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-02-01 21:58:58','2017-02-02 18:57:58',-4)-- Anna00
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-02-23 18:57:58',-4)-- Anna00
--
----CommonData  (Za Rezervaciju ) 36 - 37							datum kreiranja rezrvacije isti kao i narudzbenice
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -4) -- Anna00
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, -4) -- Anna00
----INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, 5) -- PeraCar996
--
----TAdresa
--INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-1,'BB', 'Ruma', '22420', 'Glavna')
--
--INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-2,'BB2', 'Beograd', '11000', 'Glavna2')	
--INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-3,'BB3', 'Novi Sad', '21000', '9.Marta')
--INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-4,'BB4', 'Beograd', '11000', 'Glavna2')	
--INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-5,'BB5', 'Novi Sad', '21000', '9.Marta')
--INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-6,'BB6', 'Beograd', '11000', 'Glavna2')	
--INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-7,'BB7', 'Beograd', '11000', 'Glavna2')	
--
----Cenovnik
--INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Porodicni paket',2500, 2200, 1200, 10, 25)
--INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Medjugradski cenovnik',3000, 3200, 1400, 20, 26)
--INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Gradski cenovnik',1800, 2000, 800, 50, 27)
--
----Oglas (Mogu se obrisati 4,5,6 iz guia)
--INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2021-01-01 21:58:58','2021-01-25 18:57:58',25000,-2, 1, 1, 28, 'BestUser') --reprezentativan
--INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2021-02-01 21:58:58','2021-02-25 18:57:58',3000, -3, 1, 2, 29, 'BestUser')
----INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2020-12-01 21:58:58','2020-12-22 18:57:58',12000,-4, 1, 3, 30, 'Ranko')
----INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2020-02-11 21:58:58','2018-02-15 18:57:58',16500,-5, 1, 1, 31, 'BestUser')
----INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2020-02-20 21:58:58','2020-02-25 18:57:58',4500, -6, 1, 2 ,32, 'BestUser')
----INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2020-12-10 21:58:58','2012-12-20 18:57:58',10500,-7, 2, 3, 33, 'Pera')
--
----Narudzbenice za rezervacije
--INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-02-05 21:58:58','2021-02-10 18:57:58', 1, 1, -5, 34, 1, -4)-- jos traje  -- Anna00  Anna00 dve odvojene rezerv (4,5)
--INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-01-02 21:58:58','2021-01-03 18:57:58', 1, 2, -5, 35, 2, -4)-- istekao    -- Anna00  Anna00 dve odvojene rezerv (4,5)
--
---- 3 Nove rezervacije koje su u stanju paid, od kojih su 2 istekle uspesno a jedna jos traje
--INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(false,'RESERVED', 44000, 36,'Anna00') -- jos traje
--INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(false,'PAID', 55000, 37,'Anna00') -- istekao
----INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id) VALUES(true, 'PAID', 66000, 38) -- istekao
--
----INSERT INTO Izvestaj(predjena_km,tekst_izvestaja,narudzbenica_id,automobil_id,rezervacija_id,prekoracena_km,dodatni_troskovi,common_data_id) VALUES(30000,'tekstIzvestaja1',1,1,1,5000,0,37)
----INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-01-02 21:58:58', null, -4) -- Anna00
----INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je prva poruka. Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 2, 1, 38)
----INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-01-02 21:58:58', null, -4) -- Anna00
----INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Druga poruka, u bazi, hronoloski prva!', 2, 1, 39)
----INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-01-02 21:58:58', null, -5) -- Anna00
--
-------------------------------------------------------KOMENTARIOCENA------------------------------------------------------
--
----CommonData (Za Komentar)	38-40
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)
--
----CommonData (Za Ocenu)	 41-43
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)
--
--------------------------------------------------------Poruka SERVIS------------------------------------------------------
--
----CommonData (Za Poruke) 44-47
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-4)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-4)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-04 21:58:58','2020-07-04 18:57:58',-5)
--
----Dodatna rezervacija i narudzb za slucaj kada korisnik rezervise neciji tudj oglas 48,49
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-02-23 18:57:58',-5)-- BestUser
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -5) -- BestUser
--
--INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-02-21 21:58:58','2021-02-22 18:57:58', 3, 3, -7, 48, 3, -5)
--INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(false,'PENDING', 50451, 49,'BestUser') -- jos traje
--
----Dodatna rezervacija i 2 narudzb za slucaj kada korisnik rezervise bundle tudj oglas 50 - 52
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-02-23 18:57:58',-5)-- BestUser
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -5) -- BestUser
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -5) -- BestUser
--
----Primer za bundle kod DataUser napravio rezervaciju BestUser
--INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-01-11 21:58:58','2021-01-14 18:57:58', 3, 4, -7, 50, 4, -5)
--INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-01-06 21:58:58','2021-01-10 18:57:58', 3, 4, -7, 51, 4, -5)
--INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(true,'PAID', 50451, 52,'BestUser') -- jos traje
--
----CommonData (Za Poruke) 53-56
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-4)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-4)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-04 21:58:58','2020-07-04 18:57:58',-5)
----57
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-04 21:58:58','2020-07-04 18:57:58',-5)
----Poruka
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je prva poruka usera Anna00 . Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 53, 'Anna00')
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je druga poruka usera Anna00 . Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 54, 'Anna00')
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je Prva poruka moja. Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 55, 'BestUser')
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je druga poruka moja.  Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 56, 'BestUser')
--
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je prva poruka usera Anna00 . Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 4, 1, 57, 'BestUser')
--
--
----Dodatna rezervacija i 2 narudzb za slucaj kada korisnik rezervise bundle tudj oglas 57 - 59
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-02-23 18:57:58',-3) -- Steva99
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -3) -- Steva99
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -3) -- Steva99
--
----Primer za bundle kod DataUser napravio rezervaciju BestUser
--INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-02-15 21:58:58','2021-02-19 18:57:58', 2, 5, -5, 57, null, -3)
--INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-02-06 21:58:58','2021-02-10 18:57:58', 2, 5, -5, 58, null, -3)
--INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(true,'PENDING', 55451, 59,'Steva99') -- jos traje
--



-------------------------------------------------GLAVNA BAZA #2--------------------------------------------------------------
-- admin    id: -1
-- BestUser id: -2
-- DataIser id: -3
-- agent    id: -4
-- firma    id: -5
-------------------------------------------------AUTOMOBIL SERVIS------------------------------------------------------------
--Sve pravio admin id = 1

--Adresa za usera 1-4
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES(-1,'BB', 'Ruma', '22420', 'Glavna')	
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES(-2,'Ruma', 22400,'Neznanog i znanog junaka', 35)
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES(-3,'Novi Sad',21000,'Deset Jugovica', 5)
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES(-4,'Beograd',11000,'9. Marta', 25)


--CommonData (Za TKlasaAutomobila)	1-3
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-1)

--CommonData (Za TMarkaAutomobila)	4-6
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-1)

--CommonData (Za TModelAutomobila)	7-12
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-1)

--CommonData (Za TTipMenjaca)	13-15
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-1)

--CommonData (Za TTipGoriva)	16-18
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-1)

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

--CommonData (Za Cenovnik)	19 - 21
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-3)

--Cenovnik
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Cenonvik user 1', 2500, 2000, 1200, 0, 19)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Cenovnik user 2', 3000, 3000, 1400, 0, 20)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Cenovnik user 3', 1500, 1000, 800,  0, 21)

-----------------------------------------------------------OGLAS 1 (Februar)--------------------------------------------------------------------------------------
--PRIMER PORUKA I KOMENTARA KOD PENIDNG REZERVAICJE 1
--Oglas 22
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-25 21:58:58', null, -2) -- BestUser
--Narudbenica 23
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -3) -- DataUser
--Rezervacija 24
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, -3) -- DataUser

--OGLAS 1			
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2021-02-01 21:58:58','2021-02-25 18:57:58', 12000, -2, 1, 1, 22,'BestUser')
--REZERVACIJA 1
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, user_id) VALUES('2021-02-01 21:58:58','2021-02-05 18:57:58', 1, 1, -2, 23,-3)-- DataUser  DataUser dve odvojene rezerv (1,2) ovo 1
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(false,'PENDING', 55000, 24,'DataUser') -- istekao 


--PRIMER KAKO IZGLEDA BUNDLE REZERVACIJA 2 I KAKO IZLGEDA KALENDAR KADA SE RUCNO REZERVISE PRIKAZUJU SE I PORUKE, NIJE ISTEKLA REZERV PA NEMA IZVESTAJA
--Narudbenica 25
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id) VALUES('2020-12-10 21:58:58', null, -2) -- BestUser
--Rezervacija 26
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id) VALUES('2020-12-02 21:58:58', null, -3) -- DataUser
--Narudbenica 27
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id) VALUES('2020-12-10 21:58:58', null, -3) -- DataUser

--REZERVACIJA 2
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, user_id) VALUES('2021-02-13 21:58:58','2021-02-17 18:57:58', 1, 2, -2, 25, -3)-- jos traje -- DataUser DataUser dve odvojene rezerv (1,2) ovo2
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, user_id) VALUES('2021-02-20 21:58:58','2021-02-24 18:57:58', 1, 2, -2, 26, -3)-- jos traje -- DataUser DataUser dve odvojene rezerv (1,2) ovo2
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(true,'PAID', 10000, 27,'DataUser') 



--------------------------------------------------------OGLAS 2 (Januar)--------------------------------------------------------------------------------------
--PRIMER JEDNE PAID REZERVACIJE KOD KOJE JE USPESNO PROSAO TERMIN PA MOZE IZVESTAJ DA SE OSTAVI ZA OBA AUTOMOBILA...

--Oglas 28
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-25 21:58:58', null, -2) -- BestUser
--Narudbenica1 29
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -3) -- DataUser
--Narudbenica2 30
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -3) -- DataUser
--Rezervacija 31
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, -3) -- DataUser

--OGLAS 2
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2021-01-01 21:58:58','2021-01-20 18:57:58', 12000, -3, 3, 1, 28, 'BestUser')

--REZERVACIJA 3
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, user_id) VALUES('2021-01-01 21:58:58','2021-01-05 18:57:58', 2, 3, -2, 29,-3)-- istekao  -- DataUser  
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, user_id) VALUES('2021-01-10 21:58:58','2021-01-15 18:57:58', 2, 3, -2, 30,-3)-- istekao  -- DataUser  
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(true,'PAID', 18000, 31,'DataUser') -- istekao 

-----------------------------------------------AUTOMOBIL 1 /OGLAS 1 / REZERVACIJA 1-------------------------------------------------------------------------------

--CommonData  (Za Poruke)	32 - 35 DataUser i BestUser
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-3)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-3)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-04 21:58:58','2020-07-04 18:57:58',-2)

--Poruka
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je prva poruka usera DataUser . Da li imate ova kola u crvenoj boji?', 1, 1, 32, 'DataUser')
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je druga poruka usera DataUser . Hvala Vam na brzom odgovoru.', 1, 1, 33, 'DataUser')
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je prva poruka moja. Nemamo na zalost.', 1, 1, 34, 'BestUser')
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je druga poruka moja.  Nista i drugi put.', 1, 1, 35, 'BestUser')

--OCENA i KOMENTAR 36 - 39 Namerno 2 dodata da bi imao 2 komentara i 2 ocene
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-3)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-3)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-6)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-6)

INSERT INTO Komentar(autor,tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('DataUser','Super vam je auto! ', true, 1, 1, 36) 
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(4, 1, 1, 37)

INSERT INTO Komentar(autor,tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Anna00','Bas bas vam je super auto! ', true, 1, 1, 38)
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(5, 1, 1, 39)

--OCENA i KOMENTAR ZA NEKI AUTO 2 zbog poredjenja 40 - 41 
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-6)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-6)

INSERT INTO Komentar(autor,tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Anna00','I nije neki auto! ', true, 1, 2, 40)
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(3, 1, 2, 41)


------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------AGENT DEO---------------------------------------------------------------------------------------------------------------------------------
-- admin    id: -1
-- BestUser id: -2
-- DataIser id: -3
-- agent    id: -4
-- firma    id: -5
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--
--CommonData (Za Cenovnik)	42 - 44
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-5)

--Cenovnik
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Porodicni paket',2500, 2200, 1200, 10, 42)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Medjugradski cenovnik',3000, 3200, 1400, 20, 43)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Gradski cenovnik',1800, 2000, 800, 50, 44)

-----------------------------------------------------------OGLAS 3 (Februar)--------------------------------------------------------------------------------------
--PRIMER PORUKA I KOMENTARA KOD PENIDNG REZERVAICJE 1
--Oglas 45
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-25 21:58:58', null, -4) --test agent
--Narudbenica 46
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -2)  -- BestUser
--Rezervacija 47
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, -2) -- BestUser

--OGLAS 1
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2021-02-01 21:58:58','2021-02-25 18:57:58', 12000, -1, 4, 3, 45,'agent')
--REZERVACIJA 4
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, user_id) VALUES('2021-02-01 21:58:58','2021-02-05 18:57:58', 3, 4, -4, 46,-2)-- BestUser BestUser dve odvojene rezerv (1,2) ovo 1
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username)VALUES(false,'PENDING', 10000, 47,'BestUser') -- istekao 

--PRIMER KAKO IZGLEDA BUNDLE REZERVACIJA 2 I KAKO IZLGEDA KALENDAR KADA SE RUCNO REZERVISE PRIKAZUJU SE I PORUKE, NIJE ISTEKLA REZERV PA NEMA IZVESTAJA
--Narudbenica 48
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id) VALUES('2020-12-10 21:58:58', null, -2)  -- BestUser
--Rezervacija 49
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id) VALUES('2020-12-02 21:58:58', null, -2) -- BestUser
--Narudbenica 50
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id) VALUES('2020-12-10 21:58:58', null, -2)  -- BestUser 

--REZERVACIJA 5
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, user_id) VALUES('2021-02-13 21:58:58','2021-02-17 18:57:58', 3, 5, -4, 48, -2)-- jos traje  -- BestUser  BestUser dve odvojene rezerv (1,2) ovo2
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, user_id) VALUES('2021-02-20 21:58:58','2021-02-24 18:57:58', 3, 5, -4, 49, -2)-- jos traje  -- BestUser  BestUser dve odvojene rezerv (1,2) ovo2
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(true,'PAID', 10000, 50,'BestUser') 

--------------------------------------------------------OGLAS 4 (Januar)--------------------------------------------------------------------------------------
--PRIMER JEDNE PAID REZERVACIJE KOD KOJE JE USPESNO PROSAO TERMIN PA MOZE IZVESTAJ DA SE OSTAVI ZA OBA AUTOMOBILA...

--Oglas 51
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-25 21:58:58', null, -4) -- test agent
--Narudbenica1 52
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -2) -- BestUser
--Narudbenica2 53
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -2) -- BestUser
--Rezervacija 54
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, -2) -- BestUser

--OGLAS 2
INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2021-01-01 21:58:58','2021-01-20 18:57:58', 12000, -3, 5, 3, 51,'agent')

--REZERVACIJA 6
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, user_id) VALUES('2021-01-01 21:58:58','2021-01-05 18:57:58', 4, 6, -4, 52,-2)-- istekao  -- PeraCar996  
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, user_id) VALUES('2021-01-10 21:58:58','2021-01-15 18:57:58', 4, 6, -4, 53,-2)-- istekao  -- PeraCar996  
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(false,'PAID', 18000, 54,'BestUser') -- istekao 

-----------------------------------------------------------OGLAS 3 (Mart)--------------------------------------------------------------------------------------

--PRIMER JEDNE PENDING REZERVACIJE KOD KOJE SE RADI CANCEL NPR IZBACITI DODACEMO RUCNO ZA MART OGLAS I JEDNU REZERVACIJU I TAMO PREZENTOVATI NA PRIMER MARTA

-----------------------------------------------AUTOMOBIL 1 /OGLAS 1 / REZERVACIJA 1-------------------------------------------------------------------------------

--CommonData  (Za Poruke)	55 - 58 Anna00 i Agent
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-04 21:58:58','2020-07-04 18:57:58',-4)

--Poruka
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je prva poruka usera BestUser . Da li imate ova kola u crvenoj boji?', 4, 3, 55, 'BestUse')
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je druga poruka usera BestUser . Hvala Vam na brzom odgovoru.', 4, 3, 56, 'BestUser')
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je prva poruka moja. Nemamo na zalost.', 4, 3, 57, 'agent')
INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je druga poruka moja.  Nista i drugi put.', 4, 3, 58, 'agent')


--OCENA i KOMENTAR 59 - 62 Namerno 2 dodata da bi imao 2 komentara i 2 ocene
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-6)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-6)

INSERT INTO Komentar(autor,tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('BestUser','Ovaj auto je tako kul!', true, 4, 3, 59) 
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(4, 4, 3, 60)

INSERT INTO Komentar(autor,tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Anna00','Sve pohvale! Jako dobar', true, 4, 3, 61)
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(5, 4, 3, 62)

--OCENA i KOMENTAR ZA NEKI AUTO 2 zbog poredjenja 63 - 64
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-6)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-6)

INSERT INTO Komentar(autor,tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Anna00','I nije bas neki auto! ', true, 4, 4, 63)
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(3, 4, 4, 64)


