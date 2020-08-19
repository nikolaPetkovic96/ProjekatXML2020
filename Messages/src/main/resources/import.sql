--INSERT INTO USERS(username, password,  enabled, last_password_reset_date) VALUES ('user', 'tre',  true, '2017-10-01 21:58:58.508-07')
--INSERT INTO USERS(username, password,  enabled, last_password_reset_date) VALUES ('user2', 'bell', true, '2017-10-01 18:57:58.508-07')
--INSERT INTO USERS(username, password,  enabled, last_password_reset_date) VALUES ('user3', 'bella', true, '2017-10-01 18:57:58.508-07')

--INSERT INTO AUTHORITY(name) VALUES('ROLE_USER')
--INSERT INTO AUTHORITY(name) VALUES('ROLE_ADMIN')
--INSERT INTO AUTHORITY(name) VALUES('ROLE_PACIJENT')

--INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (1, 1)
--INSERT INTO USER_AUTHORITY(user_id, authority_id) VALUES (2, 2)


-----------------------------------------------------------USER-----------------------------------------------------------------

INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2017-10-01 21:58:58','2017-10-02 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2018-02-20 21:58:58','2018-10-23 18:57:58',1)
INSERT INTO Common_data(datum_kreiranja, datum_izmene, korisnik_id)  VALUES('2019-11-04 21:58:58','2019-07-04 18:57:58',2)

--TAdresa
INSERT INTO TAdresa(mesto, postanski_broj, ulica, broj, geo_duzina, geo_sirina) VALUES('Ruma', 22400,'Neznanog i znanog junaka', 35, 45.25, 32.125)
INSERT INTO TAdresa(mesto, postanski_broj, ulica, broj, geo_duzina, geo_sirina) VALUES('Novi Sad',21000,'Deset Jugovica', 5 , 10.10, 11.111)
INSERT INTO TAdresa(mesto, postanski_broj, ulica, broj, geo_duzina, geo_sirina) VALUES('Beograd',11000,'9. Marta', 25 , 45.45, 32.23)

--SALA:
--INSERT INTO SALA(naziv, broj, rezervisana, KLINIKA_KLINIKA_ID) values ('Sala za pregled', '1', false, 1)


