
insert into authority(id,name) values (1,'ROLE_ADMIN')
insert into authority(id,name) values (2,'ROLE_USER')
insert into authority(id,name) values (3,'ROLE_AGENT')

INSERT INTO tuser(id, korisnicko_ime, lozinka) VALUES (-1, 'admin', '$2a$10$5Uh8nWhoBIuh1SuSWlvJLOD7J29rWAYhM.DtkzoJnh3TRLRlbmvpC')
	
INSERT INTO tuser_authorities(tuser_id, authorities_id) VALUES (-1, 1);