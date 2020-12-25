
insert into authority(id,name) values (1,'ROLE_ADMIN')
insert into authority(id,name) values (2,'ROLE_USER')
insert into authority(id,name) values (3,'ROLE_AGENT')

INSERT INTO tadresa(id, broj, mesto, postanski_broj, ulica) VALUES (-1,'BB', 'Ruma', '22420', 'Glavna')	
INSERT INTO tuser(id, adresa_id, email, ime, jmbg, korisnicko_ime, lozinka, naziv_firme, pol, poslovni_maticni_broj, prezime, status) VALUES (-1, -1, 'admin@admin.com', 'Admin', '18546464', 'admin', '$2a$10$5Uh8nWhoBIuh1SuSWlvJLOD7J29rWAYhM.DtkzoJnh3TRLRlbmvpC', null, 'muski', null,'Admin', 'aktivan')
INSERT INTO tuser_authorities(tuser_id, authorities_id) VALUES (-1, 1)