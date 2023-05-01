INSERT INTO departments (department_id, department_name) VALUES(1, 'Marketing');
INSERT INTO departments (department_id, department_name) VALUES(2, 'Sales');

INSERT INTO employees (employee_id, first_name, last_name, department_id) VALUES(1, 'Sara', 'Lee', 1);
INSERT INTO employees (employee_id, first_name, last_name, department_id) VALUES(2, 'Norris', 'Frank', 1);
INSERT INTO employees (employee_id, first_name, last_name, department_id) VALUES(3, 'Ainsley', 'Lincoln', 2);
INSERT INTO employees (employee_id, first_name, last_name, department_id) VALUES(4, 'Alexander', 'Ashton', 2);

INSERT INTO authors (author_id, author_name) VALUES(1, 'Ahmed');
INSERT INTO authors (author_id, author_name) VALUES(2, 'Mohammed');

INSERT INTO books (book_id, book_name, author_id) VALUES(1, 'Spring In Action', 1);
INSERT INTO books (book_id, book_name, author_id) VALUES(2, 'Kafka In Action', 1);
INSERT INTO books (book_id, book_name, author_id) VALUES(3, 'RabbitMQ In Action', 1);
INSERT INTO books (book_id, book_name, author_id) VALUES(4, 'Kubernetes In Action', 2);
INSERT INTO books (book_id, book_name, author_id) VALUES(5, 'Tomcat In Action', 2);
INSERT INTO books (book_id, book_name, author_id) VALUES(6, 'Payara In Action', 2);



INSERT INTO customers (customer_id, customer_name) VALUES(1, 'Ahmed');
INSERT INTO customers (customer_id, customer_name) VALUES(2, 'Mohammed');

INSERT INTO orders (order_id, product_name, customer_id) VALUES(1, 'Spring In Action', 1);
INSERT INTO orders (order_id, product_name, customer_id) VALUES(2, 'Kafka In Action', 1);
INSERT INTO orders (order_id, product_name, customer_id) VALUES(3, 'RabbitMQ In Action', 1);
INSERT INTO orders (order_id, product_name, customer_id) VALUES(4, 'Kubernetes In Action', 2);
INSERT INTO orders (order_id, product_name, customer_id) VALUES(5, 'Tomcat In Action', 2);
INSERT INTO orders (order_id, product_name, customer_id) VALUES(6, 'Payara In Action', 2);