create table t_roles (
    "role_id" serial not null,
    "role_name" varchar(150) not null,
    "role_descrip" varchar(150) not null,
    primary key ("role_id")
    unique("role_name")
);

create table t_users(
    "usr_id" serial not null,
    "usr_username" varchar(150) not null,
    "usr_password" varchar(255) not null,
    "usr_role_id" int not null,
    primary key ("usr_id"),
    unique("usr_username"),
    constraint "fk_user_role"
        foreign key ("usr_role_id")
            references T_ROLES ("role_id")
    on delete no action
    on update no action
);

create table t_employees(
    "emp_id" serial not null,
    "emp_dni" varchar(10) not null,
    "emp_first_name" varchar(150) not null,
    "emp_last_name" varchar(150) not null,
    "emp_email" varchar(100) not null,
    "emp_date_birth" timestamp null,
    "emp_phone_number" varchar(10) null,
    "emp_address" varchar(255) null,
    "emp_status_vac" boolean null,
    "emp_usr_id" int not null,
    primary key ("emp_id"),
    unique("emp_dni"),
    constraint "fk_employee_user"
        foreign key ("emp_usr_id")
            references T_USERS ("usr_id")
    on delete no action
    on update no action
);

create table t_doses(
    "dose_id" serial not null,
    "dose_number" int not null,
    "dose_vaccine" varchar not null,
    "dose_date" timestamp not null,
    "dose_emp_id" int not null,
    primary key ("dose_id"),
    constraint "fk_dose_employee"
        foreign key ("dose_emp_id")
            references t_employees ("emp_id")
    on delete no action
    on update no action
);