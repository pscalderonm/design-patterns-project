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