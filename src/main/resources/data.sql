USE exam_db;

    -- Skabelon
-- INSERT INTO categories (name, created, edited) VALUES ('Vegetar',NOW(),NOW());

    -- ////////////////////////////DUMMY DATA/////////////////////////////////

    -- Athletes
INSERT INTO athlete (firstname, lastname, gender, birthdate, club) VALUES ('Torben', 'Jensen', true, NOW(), "Sparta");


-- Disciplines
INSERT INTO discipline (name, result_type) VALUES ('100 m', 'tid');
INSERT INTO discipline (name, result_type) VALUES ('Spydkast', 'længde');
INSERT INTO discipline (name, result_type) VALUES ('Højdespring', 'højde');
INSERT INTO discipline (name, result_type) VALUES ('800 m', 'tid');