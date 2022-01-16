insert into bank_user(id,name,gender,birthday,u_type) values (1,'user1','M','1980-01-01','CUSTOMER');
insert into bank_user(id,name,gender,birthday,u_type) values (2,'user2','F','1980-01-02','CUSTOMER');
insert into bank_user(id,name,gender,birthday,u_type) values (3,'user3','F','1980-01-03','EMPLOYEE');





insert into account(id,account,state, pwd_hash, user_id, balance, last_update_date, last_update_process, last_update_user, create_date, create_user)
            values (1,'account1', 'ACTIVE','$2a$10$bHw13zr6a2S6SAT19DVzo.WO3qZCOSr89SS2pDpGev2EOj7EIJQTu', 1, 100.52, current_date, 'BK', 3, current_date, 3);-----password is 123123
insert into account(id,account, state, pwd_hash, user_id, balance, last_update_date, last_update_process, last_update_user, create_date, create_user)
            values (2,'account2','ACTIVE','$2a$10$bHw13zr6a2S6SAT19DVzo.WO3qZCOSr89SS2pDpGev2EOj7EIJQTu', 1, 200.55, current_date, 'BK', 3, current_date, 3);

