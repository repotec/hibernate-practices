CREATE TABLE users(user_id INT NOT NULL, user_name VARCHAR(50) NOT NULL);
CREATE TABLE groups(group_id INT NOT NULL, group_name VARCHAR(50) NOT NULL);
CREATE TABLE user_groups(user_id INT NOT NULL, group_id INT NOT NULL);