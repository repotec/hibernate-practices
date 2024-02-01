CREATE TABLE authors(author_id INT,author_name VARCHAR(400), CONSTRAINT pk_author PRIMARY KEY (author_id));
CREATE TABLE books(book_id INT, title VARCHAR(400), author_id INT, CONSTRAINT fk_book_author FOREIGN KEY (author_id) REFERENCES authors (author_id));


