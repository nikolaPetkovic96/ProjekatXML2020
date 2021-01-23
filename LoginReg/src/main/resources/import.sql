
insert into authority(id,name) values (1,'ROLE_ADMIN')
insert into authority(id,name) values (2,'ROLE_USER')
insert into authority(id,name) values (3,'ROLE_AGENT')

--Adresa za usera 1-4
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES(1,'BB', 'Ruma', '22420', 'Glavna')	
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES(2,'Ruma', 22400,'Neznanog i znanog junaka', 35)
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES(3,'Novi Sad',21000,'Deset Jugovica', 5)
INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES(4,'Beograd',11000,'9. Marta', 25)

--Admin
INSERT INTO tuser(id, adresa_id, email, ime, jmbg, korisnicko_ime, lozinka, naziv_firme, pol, poslovni_maticni_broj, prezime, status,allowed_to_commend, allowed_to_make_reservation, allowed_to_message) VALUES (1, -1, 'admin@admin.com', 'Admin', '18546464', 'admin', '$2a$10$5Uh8nWhoBIuh1SuSWlvJLOD7J29rWAYhM.DtkzoJnh3TRLRlbmvpC', null, 'Muski', null,'Admin', 'aktivan',true,true,true) --pass: admin
--User
INSERT INTO tuser(id, adresa_id, email, ime, jmbg, korisnicko_ime, lozinka, naziv_firme, pol, poslovni_maticni_broj, prezime, status,allowed_to_commend, allowed_to_make_reservation, allowed_to_message) VALUES (2, -2, 'blage500@gmail.com', 'User', '101004510101', 'BestUser', '$2a$10$5Uh8nWhoBIuh1SuSWlvJLOD7J29rWAYhM.DtkzoJnh3TRLRlbmvpC', null, 'Muski', null,'Korisnikovic', 'aktivan',true,true,true) --pass: admin
INSERT INTO tuser(id, adresa_id, email, ime, jmbg, korisnicko_ime, lozinka, naziv_firme, pol, poslovni_maticni_broj, prezime, status,allowed_to_commend, allowed_to_make_reservation, allowed_to_message) VALUES (3, -2, 'testxml2020@gmail.com', 'Duser', '10102130101', 'DataUser', '$2a$10$5Uh8nWhoBIuh1SuSWlvJLOD7J29rWAYhM.DtkzoJnh3TRLRlbmvpC', null, 'Muski', null,'Podatkovic', 'aktivan',true,true,true) --pass: admin
--Agent
INSERT INTO tuser(id, adresa_id, email, ime, jmbg, korisnicko_ime, lozinka, naziv_firme, pol, poslovni_maticni_broj, prezime, status,allowed_to_commend, allowed_to_make_reservation, allowed_to_message) VALUES (4, -3, 'blagea500@gmail.com', 'Marko', '101004510101', 'agent', '$2a$10$786OZQwAuZ.Y8Nw6dm12SeyXW7r/M7sHb6aJZNHerDEjIGt4FlJlS', null, 'Muski', null,'Korisnikovic', 'aktivan',true,true,true) --pass: test
INSERT INTO tuser(id, adresa_id, email, ime, jmbg, korisnicko_ime, lozinka, naziv_firme, pol, poslovni_maticni_broj, prezime, status,allowed_to_commend, allowed_to_make_reservation, allowed_to_message) VALUES (5, -4, 'testxmla2020@gmail.com', 'NULL', 'NULL', 'firma', '$2a$10$ThUT1iTXIkCMfPpCfBfC4eEPl.0L.9yAhIiNNqGk7/6tDnInnyYMS', 'TheBestFirma', null,'7604513',null, 	'aktivan',true,true,true) --pass: firma

----Dodatni User
INSERT INTO tuser(id, adresa_id, email, ime, jmbg, korisnicko_ime, lozinka, naziv_firme, pol, poslovni_maticni_broj, prezime, status,allowed_to_commend, allowed_to_make_reservation, allowed_to_message) VALUES (6, -3, 'blageaa500@gmail.com', 'Ana', '101004510101', 'Anna00', '$2a$10$786OZQwAuZ.Y8Nw6dm12SeyXW7r/M7sHb6aJZNHerDEjIGt4FlJlS', null, 'Zenski', null,'Anic', 'aktivan',true,true,true) --pass: admin


INSERT INTO tuser_authorities(tuser_id, authorities_id) VALUES (1, 1)
INSERT INTO tuser_authorities(tuser_id, authorities_id) VALUES (2, 2)
INSERT INTO tuser_authorities(tuser_id, authorities_id) VALUES (3, 2)
INSERT INTO tuser_authorities(tuser_id, authorities_id) VALUES (4, 3)
INSERT INTO tuser_authorities(tuser_id, authorities_id) VALUES (5, 3)

INSERT INTO tuser_authorities(tuser_id, authorities_id) VALUES (6, 2)




