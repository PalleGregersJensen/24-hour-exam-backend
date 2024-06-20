USE exam_db;

    -- Skabelon
-- INSERT INTO categories (name, created, edited) VALUES ('Vegetar',NOW(),NOW());

    -- //////////////////////////// DUMMY DATA /////////////////////////////////

    -- /////////////////// ATHLETES //////////////////
INSERT INTO athlete (firstname, lastname, gender, birthdate, club) VALUES ('Torben', 'Jensen', true, NOW(), 'Sparta');


-- ////////////////// DISCIPLINES /////////////////
INSERT INTO discipline (name, result_type) VALUES ('100 m', 'tid');
INSERT INTO discipline (name, result_type) VALUES ('Spydkast', 'længde');
INSERT INTO discipline (name, result_type) VALUES ('Højdespring', 'højde');
INSERT INTO discipline (name, result_type) VALUES ('800 m', 'tid');

-- ///////////////////// RESULTS //////////////////////
INSERT INTO result (result_date, result_type, result_value, athlete_id_fk, discipline_id_fk) VALUES (NOW(), 'tid', '10.55', 1, 1);

-- ///////////////////// ATHLETE-DISCIPLINE ///////////////////////////
INSERT INTO athlete_discipline(athlete_id, discipline_id) VALUES (1, 1);