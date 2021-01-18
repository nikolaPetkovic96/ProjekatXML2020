-------------------------------------------------OGLAS BAZA #2-------------------------------------------------

--CommonData (Za TKlasaAutomobila)	1-3
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za TMarkaAutomobila)	4-6
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za TModelAutomobila)	7-12
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za TTipMenjaca)	13-15
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za TTipGoriva)	16-18
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--CommonData (Za Automobile)	19-24
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-5) --pripada BestUser
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5) --pripada BestUser
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-5) --pripada BestUser
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5) --pripada BestUser
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-3)

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

--Automobil
--INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (1, true, 1, 1, 1, 56000, 3,1, 3.8, 19)
--INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (2, true, 2, 1, 2, 6700, 1, 2, 4.5, 20)
--INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (1, true, 3, 2, 3, 526000, 2,1, 3.6, 21)
--INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (2, true, 1, 2, 4, 56000, 3,1, 3.8, 22)
--INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (0, true, 2, 3, 5, 6700, 1,2, 4.5, 23)
--INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (4, true, 3, 3, 6, 86000, 2,1, 3.6, 24)

------------------------------------------------------OGLAS SERVIS------------------------------------------------------

--CommonData (Za Cenovnik)	25 - 27
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-5)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-3)


--CommonData (Za Oglase)	28 - 33
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-5) --pripada BestUser
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5) --pripada BestUser
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-5) --pripada BestUser
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5) --pripada BestUser
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-3)

--CommonData (Za Narudzbenicu)	34 - 35
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-02-01 21:58:58','2017-02-02 18:57:58',-4)-- Anna00
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-02-23 18:57:58',-4)-- Anna00

--CommonData  (Za Rezervaciju ) 36 - 37							datum kreiranja rezrvacije isti kao i narudzbenice
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -4) -- Anna00
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-02 21:58:58', null, -4) -- Anna00
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, 5) -- PeraCar996

--TAdresa
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-1,'BB', 'Ruma', '22420', 'Glavna')

INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-2,'BB2', 'Beograd', '11000', 'Glavna2')	
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-3,'BB3', 'Novi Sad', '21000', '9.Marta')
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-4,'BB4', 'Beograd', '11000', 'Glavna2')	
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-5,'BB5', 'Novi Sad', '21000', '9.Marta')
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-6,'BB6', 'Beograd', '11000', 'Glavna2')	
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-7,'BB7', 'Beograd', '11000', 'Glavna2')	

--Cenovnik
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Porodicni paket',2500, 2200, 1200, 10, 25)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Medjugradski cenovnik',3000, 3200, 1400, 20, 26)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Gradski cenovnik',1800, 2000, 800, 50, 27)

--Oglas (Mogu se obrisati 4,5,6 iz guia)
--INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2021-01-01 21:58:58','2021-01-25 18:57:58',25000,-2, 1, 1, 28, 'BestUser') --reprezentativan
--INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2021-02-01 21:58:58','2021-02-25 18:57:58',3000, -3, 1, 2, 29, 'BestUser')
--INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2020-12-01 21:58:58','2020-12-22 18:57:58',12000,-4, 1, 3, 30, 'Ranko')
--INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2020-02-11 21:58:58','2018-02-15 18:57:58',16500,-5, 1, 1, 31, 'BestUser')
--INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2020-02-20 21:58:58','2020-02-25 18:57:58',4500, -6, 1, 2 ,32, 'BestUser')
--INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id, username) VALUES('2020-12-10 21:58:58','2012-12-20 18:57:58',10500,-7, 2, 3, 33, 'Pera')

--Narudzbenice za rezervacije
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-02-05 21:58:58','2021-02-10 18:57:58', 1, 1, -5, 34, 1, -4)-- jos traje  -- Anna00  Anna00 dve odvojene rezerv (4,5)
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-01-02 21:58:58','2021-01-03 18:57:58', 1, 2, -5, 35, 2, -4)-- istekao    -- Anna00  Anna00 dve odvojene rezerv (4,5)

-- 3 Nove rezervacije koje su u stanju paid, od kojih su 2 istekle uspesno a jedna jos traje
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(false,'RESERVED', 44000, 36,'Anna00') -- jos traje
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(false,'PAID', 55000, 37,'Anna00') -- istekao
--INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id) VALUES(true, 'PAID', 66000, 38) -- istekao

--INSERT INTO Izvestaj(predjena_km,tekst_izvestaja,narudzbenica_id,automobil_id,rezervacija_id,prekoracena_km,dodatni_troskovi,common_data_id) VALUES(30000,'tekstIzvestaja1',1,1,1,5000,0,37)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-01-02 21:58:58', null, -4) -- Anna00
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Ovo je prva poruka. Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 2, 1, 38)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-01-02 21:58:58', null, -4) -- Anna00
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id) VALUES('Druga poruka, u bazi, hronoloski prva!', 2, 1, 39)
--INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-01-02 21:58:58', null, -5) -- Anna00

-----------------------------------------------------KOMENTARIOCENA------------------------------------------------------

--CommonData (Za Komentar)	38-40
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Ocenu)	 41-43
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

------------------------------------------------------Poruka SERVIS------------------------------------------------------

--CommonData (Za Poruke) 44-47
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-04 21:58:58','2020-07-04 18:57:58',-5)

--Dodatna rezervacija i narudzb za slucaj kada korisnik rezervise neciji tudj oglas 48,49
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-02-23 18:57:58',-5)-- BestUser
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -5) -- BestUser

INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-02-21 21:58:58','2021-02-22 18:57:58', 3, 3, -7, 48, 3, -5)
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(false,'PENDING', 50451, 49,'BestUser') -- jos traje

--Dodatna rezervacija i 2 narudzb za slucaj kada korisnik rezervise bundle tudj oglas 50 - 52
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-02-23 18:57:58',-5)-- BestUser
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -5) -- BestUser
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -5) -- BestUser

--Primer za bundle kod DataUser napravio rezervaciju BestUser
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-01-11 21:58:58','2021-01-14 18:57:58', 3, 4, -7, 50, 4, -5)
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-01-06 21:58:58','2021-01-10 18:57:58', 3, 4, -7, 51, 4, -5)
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(true,'PAID', 50451, 52,'BestUser') -- jos traje

--CommonData (Za Poruke) 53-56
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',-4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-04 21:58:58','2020-07-04 18:57:58',-5)
--57
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-11-04 21:58:58','2020-07-04 18:57:58',-5)
--Poruka
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je prva poruka usera Anna00 . Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 53, 'Anna00')
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je druga poruka usera Anna00 . Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 54, 'Anna00')
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je Prva poruka moja. Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 55, 'BestUser')
--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je druga poruka moja.  Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 1, 1, 56, 'BestUser')

--INSERT INTO Poruka(tekst_poruke, rezervacija_id, automobil_id, common_data_id, username) VALUES('Ovo je prva poruka usera Anna00 . Dsds adasd sad dasd asdwqe fbnfdj d rdaes.', 4, 1, 57, 'BestUser')


--Dodatna rezervacija i 2 narudzb za slucaj kada korisnik rezervise bundle tudj oglas 57 - 59
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-02-23 18:57:58',-3) -- Steva99
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -3) -- Steva99
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2020-12-10 21:58:58', null, -3) -- Steva99

--Primer za bundle kod DataUser napravio rezervaciju BestUser
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-02-15 21:58:58','2021-02-19 18:57:58', 2, 5, -5, 57, null, -3)
INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id, izvestaj_id, user_id) VALUES('2021-02-06 21:58:58','2021-02-10 18:57:58', 2, 5, -5, 58, null, -3)
INSERT INTO Rezervacija(bundle, status_rezerv, ukupna_cena, common_data_id, username) VALUES(true,'PENDING', 55451, 59,'Steva99') -- jos traje

