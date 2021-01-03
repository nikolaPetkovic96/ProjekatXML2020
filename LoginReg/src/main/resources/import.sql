
insert into authority(id,name) values (1,'ROLE_ADMIN')
insert into authority(id,name) values (2,'ROLE_USER')
insert into authority(id,name) values (3,'ROLE_AGENT')

INSERT INTO TAdresa(id, broj, mesto, postanski_broj, ulica) VALUES (-1,'BB', 'Ruma', '22420', 'Glavna')	
INSERT INTO tuser(id, adresa_id, email, ime, jmbg, korisnicko_ime, lozinka, naziv_firme, pol, poslovni_maticni_broj, prezime, status,allowed_to_commend, allowed_to_make_reservation, allowed_to_message) VALUES (-1, -1, 'admin@admin.com', 'Admin', '18546464', 'admin', '$2a$10$5Uh8nWhoBIuh1SuSWlvJLOD7J29rWAYhM.DtkzoJnh3TRLRlbmvpC', null, 'muski', null,'Admin', 'aktivan',true,true,true)
INSERT INTO tuser(id, adresa_id, email, ime, jmbg, korisnicko_ime, lozinka, naziv_firme, pol, poslovni_maticni_broj, prezime, status,allowed_to_commend, allowed_to_make_reservation, allowed_to_message) VALUES (-2, -1, 'eva@admin.com', 'Eva', '18123464', 'Eva00', '$2a$10$5Uh8nWhoBIuh1SuSWlvJLOD7J30rWAYhM.DtkzoJnh3TRLRlbmvpC', null, 'zenski', null,'Admin', 'aktivan',false,false,false)
INSERT INTO tuser(id, adresa_id, email, ime, jmbg, korisnicko_ime, lozinka, naziv_firme, pol, poslovni_maticni_broj, prezime, status,allowed_to_commend, allowed_to_make_reservation, allowed_to_message) VALUES (-3, -1, 'steva@admin.com', 'Steva', '182342464', 'Steva99', '$2a$10$5Uh8nWhoBIuh1SuSWlvJLOD7J31rWAYhM.DtkzoJnh3TRLRlbmvpC', null, 'muski', null,'Admin', 'aktivan',true,true,true)
INSERT INTO tuser(id, adresa_id, email, ime, jmbg, korisnicko_ime, lozinka, naziv_firme, pol, poslovni_maticni_broj, prezime, status,allowed_to_commend, allowed_to_make_reservation, allowed_to_message) VALUES (-4, -1, 'anna@admin.com', 'Ana', '185213464', 'Anna00', '$2a$10$5Uh8nWhoBIuh1SuSWlvJLOD7J32rWAYhM.DtkzoJnh3TRLRlbmvpC', null, 'zenski', null,'Admin', 'aktivan',true,false,true)

INSERT INTO tuser_authorities(tuser_id, authorities_id) VALUES (-1, 1)
INSERT INTO tuser_authorities(tuser_id, authorities_id) VALUES (-2, 2)
INSERT INTO tuser_authorities(tuser_id, authorities_id) VALUES (-3, 2)
INSERT INTO tuser_authorities(tuser_id, authorities_id) VALUES (-4, 2)