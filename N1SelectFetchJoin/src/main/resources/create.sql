CREATE TABLE departments(department_id INT, department_name VARCHAR(100));
CREATE TABLE employees(employee_id INT, first_name VARCHAR(100), last_name VARCHAR(100), department_id INT);

CREATE TABLE customers(customer_id INT, customer_name VARCHAR(100));
CREATE TABLE orders(order_id INT, product_name VARCHAR(100), customer_id INT);