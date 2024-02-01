CREATE TABLE users(id INT, username VARCHAR(100), address_id INT);
CREATE TABLE addresses(id INT, street VARCHAR(100), city VARCHAR(100));

CREATE TABLE posts(id INT, title VARCHAR(100));
CREATE TABLE post_details(id INT, content VARCHAR(100));

CREATE TABLE employees(id INT, name VARCHAR(100));
CREATE TABLE workstation(id INT, floor INT);
CREATE TABLE emp_workstation(workstation_id INT, employee_id INT);

CREATE TABLE clerks(id INT, name VARCHAR(100), job_id int);
CREATE TABLE jobs(id INT, title VARCHAR(100));

CREATE TABLE publishers(publisher_id_pk INT, name VARCHAR(100));
CREATE TABLE books(bookId INT, title VARCHAR(100), publisher_id_fk int);
