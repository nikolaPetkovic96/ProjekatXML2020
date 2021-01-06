INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES 	('2017-10-01 21:58:58','2017-10-02 18:57:58',1);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES  ('2017-10-01 21:58:58','2017-10-02 18:57:58',2);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES  ('2017-10-01 21:58:58','2017-10-02 18:57:58',3);
INSERT INTO oglas(adresa_id, automobil_id, cenovnik_id, common_data_id, do_datuma, od_datuma, planirana_km, username) VALUES (1,2,1,1,'2017-10-02 18:57:58','2017-10-01 21:58:58',12,'user1');
INSERT INTO oglas(adresa_id, automobil_id, cenovnik_id, common_data_id, do_datuma, od_datuma, planirana_km, username) VALUES (1,1,2,2,'2017-10-02 18:57:58','2017-10-01 21:58:58',12,'user2');
INSERT INTO oglas(adresa_id, automobil_id, cenovnik_id, common_data_id, do_datuma, od_datuma, planirana_km, username) VALUES (1,3,1,3,'2017-10-02 18:57:58','2017-10-01 21:58:58',12,'user3');

INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',1);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',1);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',2);
INSERT INTO automobil(br_sedista_za_decu, col_dmg_waiver, common_data_id, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, ukupna_ocena, vrsta_goriva_id) VALUES (1, true, 4, 1, 1, 1, 100200,0,1000,0);
INSERT INTO automobil(br_sedista_za_decu, col_dmg_waiver, common_data_id, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, ukupna_ocena, vrsta_goriva_id) VALUES(2, true, 5, 2, 1, 1, 100200,1,1200,0);
INSERT INTO automobil(br_sedista_za_decu, col_dmg_waiver, common_data_id, klasa_automobila_id, marka_automobila_id, model_automobila_id, predj_kilom, tip_menjaca_id, ukupna_ocena, vrsta_goriva_id) VALUES (0, false, 6, 1, 2, 2, 104000,0,1400,1);


INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',1);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',1);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',1);
INSERT INTO cenovnik(cena_col_dmge_waiver, cena_po_danu, cena_km, common_data_id, naziv_cenovnika, popust30) VALUES (10,5,10,7,'cenovnik 1',12);
INSERT INTO cenovnik(cena_col_dmge_waiver, cena_po_danu, cena_km, common_data_id, naziv_cenovnika, popust30) VALUES (120,4,10,8,'cenovnik 2',90);
INSERT INTO cenovnik(cena_col_dmge_waiver, cena_po_danu, cena_km, common_data_id, naziv_cenovnika, popust30) VALUES (14,3,10,9,'cenovnik 3',3);


INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',2);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',1);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',3);
INSERT INTO izvestaj(automobil_id, common_data_id, dodatni_troskovi, narudzbenica_id, predjena_km, prekoracena_km, rezervacija_id, tekst_izvestaja)	VALUES (1,10,90,1,12,0,1,'tekst izvestaja 1');
INSERT INTO izvestaj(automobil_id, common_data_id, dodatni_troskovi, narudzbenica_id, predjena_km, prekoracena_km, rezervacija_id, tekst_izvestaja)	VALUES(2,11,50,1,123,4,1,'tekst izvestaja 2');
INSERT INTO izvestaj(automobil_id, common_data_id, dodatni_troskovi, narudzbenica_id, predjena_km, prekoracena_km, rezervacija_id, tekst_izvestaja)	VALUES(2,12,9,1,122,10,2,'tekst izvestaja 3');


INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',2);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',1);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',3);
INSERT INTO narudzbenica(agent_id, common_data_id, do_datuma, izvestaj_id, od_datuma, oglas_id, rezervacija_id, user_id) VALUES (1, 13, '2017-10-02 18:57:58', 1,'2017-10-01 21:58:58', 1, 1, 1);
INSERT INTO narudzbenica(agent_id, common_data_id, do_datuma, izvestaj_id, od_datuma, oglas_id, rezervacija_id, user_id) VALUES (1, 14, '2017-10-02 18:57:58', 2,'2017-10-01 21:58:58', 2, 1, 1);
INSERT INTO narudzbenica(agent_id, common_data_id, do_datuma, izvestaj_id, od_datuma, oglas_id, rezervacija_id, user_id) VALUES (1, 15, '2017-10-02 18:57:58', null,'2017-10-01 21:58:58', 1, 2,2);


INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',2);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',1);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',3);
INSERT INTO rezervacija(bundle, common_data_id, napomena, status_rezerv, ukupna_cena) VALUES (true,16,'nap1','paid',100);
INSERT INTO rezervacija(bundle, common_data_id, napomena, status_rezerv, ukupna_cena) VALUES (true,17,'nap2','wait',100);

INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',2);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',1);
INSERT INTO common_data(datum_izmene, datum_kreiranja, korisnik_id) VALUES ('2017-10-01 21:58:58','2017-10-02 18:57:58',3);
INSERT INTO tadresa(broj, common_data_id, mesto, postanski_broj, ulica) VALUES (1,18,'ns',21000,'bulevar oslodbodjenja');
INSERT INTO tadresa(broj, common_data_id, mesto, postanski_broj, ulica) VALUES (10,19,'nis',18000,'dusanova');
INSERT INTO tadresa(broj, common_data_id, mesto, postanski_broj, ulica) VALUES (45,20,'ns',21000,'laze Stajica');


