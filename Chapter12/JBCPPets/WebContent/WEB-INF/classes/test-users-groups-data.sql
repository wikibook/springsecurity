insert into groups(group_name) values ('Users');
insert into groups(group_name) values ('Administrators');

insert into group_authorities(group_id, authority) select id,'ROLE_USER' from groups where group_name='Users'; 
insert into group_authorities(group_id, authority) select id,'ROLE_USER' from groups where group_name='Administrators'; 
insert into group_authorities(group_id, authority) select id,'ROLE_ADMIN' from groups where group_name='Administrators'; 

--insert into users(username, password, enabled) values ('admin','admin',true);
--insert into users(username, password, enabled) values ('guest','guest',true);

-- Ch 4 Salted User
insert into users(username, password, enabled, salt) values ('admin','admin',true,CAST(RAND()*1000000000 AS varchar));
insert into users(username, password, enabled, salt) values ('guest','guest',true,CAST(RAND()*1000000000 AS varchar));

insert into group_members(group_id, username) select id,'guest' from groups where group_name='Users';
insert into group_members(group_id, username) select id,'admin' from groups where group_name='Administrators';

-- Ch 7 Custom Permission
insert into users(username, password, enabled, salt) values ('admin2','admin2',true,CAST(RAND()*1000000000 AS varchar));
insert into group_members(group_id, username) select id,'admin2' from groups where group_name='Administrators';

-- ch 12
insert into users(username, password, enabled, salt) values ('kerbuser@CORP.JBCPPETS.COM','unused',true,CAST(RAND()*1000000000 AS varchar));
insert into group_members(group_id, username) select id,'kerbuser@CORP.JBCPPETS.COM' from groups where group_name='Administrators';

commit;
