INSERT INTO t_roles (role_name, role_descrip) VALUES('ADMIN', 'admin role');
INSERT INTO t_roles (role_name, role_descrip) VALUES('EMPLOYEE', 'employee role');

INSERT INTO t_users (usr_username,usr_password, usr_role_id) VALUES  ('bvega','admin.123',1);