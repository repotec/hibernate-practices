CREATE TABLE employees(employee_id INT, first_name VARCHAR(100), last_name VARCHAR(100), street VARCHAR(20), city VARCHAR(30), country VARCHAR(30), zip_code VARCHAR(20));
CREATE TABLE companies(company_id INT, company_name VARCHAR(100), address VARCHAR(100), first_name VARCHAR(20), middle_name VARCHAR(30), last_name VARCHAR(30), phone VARCHAR(30));

--collections
CREATE TABLE developers (id INT, name VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE developer_languages (developer_id INT, languages VARCHAR(255), FOREIGN KEY (developer_id) REFERENCES developers(id));
CREATE TABLE developer_frameworks (developer_id INT, frameworks VARCHAR(255), FOREIGN KEY (developer_id) REFERENCES developers(id));


--collections embedded
CREATE TABLE clerks (clerk_id_pk INT, name VARCHAR(255), PRIMARY KEY (clerk_id_pk));
CREATE TABLE jobs (job_id_pk INT, title VARCHAR(255), clerk_id_fk INT, FOREIGN KEY (clerk_id_fk) REFERENCES clerks(clerk_id_pk));