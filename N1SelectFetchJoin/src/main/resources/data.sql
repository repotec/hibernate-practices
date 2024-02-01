INSERT INTO departments (department_id, department_name) VALUES(1, 'Marketing');
INSERT INTO departments (department_id, department_name) VALUES(2, 'Sales');

INSERT INTO employees (employee_id, first_name, last_name, department_id) VALUES(1, 'Sara', 'Lee', 1);
INSERT INTO employees (employee_id, first_name, last_name, department_id) VALUES(2, 'Norris', 'Frank', 1);
INSERT INTO employees (employee_id, first_name, last_name, department_id) VALUES(3, 'Ainsley', 'Lincoln', 2);
INSERT INTO employees (employee_id, first_name, last_name, department_id) VALUES(4, 'Alexander', 'Ashton', 2);


INSERT INTO customers (customer_id, customer_name) VALUES(1, 'ahmed');
INSERT INTO customers (customer_id, customer_name) VALUES(2, 'mohammed');

INSERT INTO orders (order_id, product_name, customer_id) VALUES(1, 'Iphone', 1);
INSERT INTO orders (order_id, product_name, customer_id) VALUES(2, 'IPad', 1);
INSERT INTO orders (order_id, product_name, customer_id) VALUES(2, 'EarPods', 1);
INSERT INTO orders (order_id, product_name, customer_id) VALUES(1, 'Iphone', 2);
INSERT INTO orders (order_id, product_name, customer_id) VALUES(2, 'IPad', 2);
INSERT INTO orders (order_id, product_name, customer_id) VALUES(2, 'EarPods', 2);