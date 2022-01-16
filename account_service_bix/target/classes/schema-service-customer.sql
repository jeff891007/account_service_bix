drop table if exists account ;
drop table if exists bank_user ;


create table bank_user
(
id int auto_increment primary key not null,
name varchar(20) null,
gender varchar(1) null,
birthday date null,
u_type varchar(10) null
);


create table account
(
id int auto_increment primary key not null,
account varchar(20) null,
state   varchar(20) null,
pwd_hash varchar(100) null,
user_id int null,
balance double null,
last_update_date date null,
last_update_process varchar(100) null,
last_update_user int null,
create_date date null,
create_user int null,
FOREIGN KEY (user_id) REFERENCES bank_user(id),
FOREIGN KEY (create_user) REFERENCES bank_user(id)
);

