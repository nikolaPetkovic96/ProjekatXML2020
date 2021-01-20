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

--CommonData (Za Cenovnik)	25-27
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',-5)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',-5)
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
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (1, true, 1, 1, 1, 56000, 3,1, 3.8, 19)
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (2, true, 2, 1, 2, 6700, 1, 2, 4.5, 20)
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (1, true, 3, 2, 3, 526000, 2,1, 3.6, 21)
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (2, true, 1, 2, 4, 56000, 3,1, 3.8, 22)
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (0, true, 2, 3, 5, 6700, 1,2, 4.5, 23)
INSERT INTO Automobil(br_sedista_za_decu, col_dmg_waiver, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, vrsta_goriva_id, ukupna_ocena, common_data_id) VALUES (4, true, 3, 3, 6, 86000, 2,1, 3.6, 24)

--Cenovnik
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Porodicni paket',2500, 2200, 1200, 10, 25)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Medjugradski cenovnik',3000, 3200, 1400, 20, 26)
INSERT INTO Cenovnik(naziv_cenovnika, cena_col_dmge_waiver, cena_po_danu, cena_po_km, popust_30_dan, common_data_id) VALUES('Gradski cenovnik',1800, 2000, 800, 50, 27)