CREATE TABLE users(id INT, username VARCHAR(100), address_id INT);
CREATE TABLE addresses(id INT, street VARCHAR(100), city VARCHAR(100));

CREATE TABLE posts(id INT, title VARCHAR(100));
CREATE TABLE post_details(id INT, created_on DATE, created_by VARCHAR(100), post_id INT);

CREATE TABLE employees(id INT, name VARCHAR(100));
CREATE TABLE workstation(id INT, floor INT);
CREATE TABLE emp_workstation(workstation_id INT, employee_id INT);