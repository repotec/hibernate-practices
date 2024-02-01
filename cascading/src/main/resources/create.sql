--all tables here for just illustration. Hibernate will created them all in application initialization phase
-- we use hibernate.hbm2ddl.auto" value="create-drop"

CREATE TABLE authors(author_id INT,author_name VARCHAR(400));
CREATE TABLE books(book_id INT, title VARCHAR(400), author_id INT);

CREATE TABLE orders(order_id INT, total_price INT);
CREATE TABLE items(item_id INT, item_name VARCHAR(400), order_id_fk INT);

CREATE TABLE applications (
APPLICATION_ID_PK INT not null,
APPLICATION_NAME varchar(255),
primary key (APPLICATION_ID_PK)
);

CREATE TABLE application_translations (
APPLICATION_TRANSLATION_ID INT not null,
APPLICATION_DISPLAY_NAME varchar(255),
application_id_fk INT,
primary key (APPLICATION_TRANSLATION_ID)
)