CREATE TABLE authors(author_id INT,author_name VARCHAR(400));
CREATE TABLE books(book_id INT, title VARCHAR(400), author_id INT);

CREATE TABLE purchase_orders(order_id INT, total_price INT);
CREATE TABLE items(item_id INT, item_name VARCHAR(400), fk_order_id INT);
