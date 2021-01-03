--CommonData (Za Komentar)	1-3
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Ocenu)	 4-6
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',2)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',3)

--CommonData (Za Usere) id: 7 - 9
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',4)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',4)


--Komentar
INSERT INTO Komentar(autor, tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Darkooo91','Od Darkooo91 komentar neki  ocena 4! ', true, 1, 1, 1) --za porse 911
INSERT INTO Komentar(autor, tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('Anna00',   'Od Anna00 komentar neki ocena 5! ',     true, 2, 1, 2) --za porse 911
INSERT INTO Komentar(autor, tekst_komentara, odobren, rezervacija_id, automobil_id, common_data_id) VALUES('PeraCar996', 'Od PeraCar996 Komentar neki ocena 2', true, 3, 1, 3) --za porse 911

--Ocena
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(4, 1, 1, 4)
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(5, 2, 1, 5)
INSERT INTO Ocena(vredn_ocene, rezervacija_id, automobil_id, common_data_id) VALUES(2, 3, 1, 6)


--Rezervacija
--INSERT INTO Rezervacija(bundle, status_rezerv, napomena_rezerv, ukupna_cena, common_data_id) VALUES(true, 'PENDING','Sve super' 22000, 10)

--Narudzbenica
--INSERT INTO Narudzbenica(od_datuma, do_datuma, oglas_id, rezervacija_id, agent_id, common_data_id) VALUES('2021-01-05 21:58:58','2021-01-10 18:57:58', 1, 1, 1, 52)

--Oglas
--INSERT INTO Oglas(od_datuma, do_datuma, plan_km, adresa_id, cenovnik_id, automobil_id, common_data_id) VALUES('2021-01-01 21:58:58','2021-01-25 18:57:58',25000,1, 1, 1, 46) --reprezentativan

--Automobil
--INSERT INTO Automobil(bundle, status_rezerv, napomena_rezerv, ukupna_cena, common_data_id) VALUES(true, 'PENDING','Sve super' 22000, 10)
