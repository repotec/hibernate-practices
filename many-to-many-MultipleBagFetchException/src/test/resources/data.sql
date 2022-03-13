INSERT INTO users(user_id, user_name) VALUES(1, 'Sara');
INSERT INTO users(user_id, user_name) VALUES(2, 'Frank');

INSERT INTO groups(group_id, group_name) VALUES(1, 'ADMIN');
INSERT INTO groups(group_id, group_name) VALUES(2, 'HR');
INSERT INTO groups(group_id, group_name) VALUES(3, 'SALES');

INSERT INTO user_groups(user_id, group_id) VALUES(1, 1);
INSERT INTO user_groups(user_id, group_id) VALUES(1, 2);
INSERT INTO user_groups(user_id, group_id) VALUES(2, 2);
INSERT INTO user_groups(user_id, group_id) VALUES(2, 1);