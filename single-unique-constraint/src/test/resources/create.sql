CREATE TABLE books(id INT, name VARCHAR(50), isbn VARCHAR(50));
ALTER TABLE books ADD CONSTRAINT name_unq UNIQUE(name);