create table login(
userName varchar(50) not null,
password varchar(50));


insert into login values("admin", "admin@123"); 
insert into login values("admin", "admin@123"); 


create table change_role(
username varchar(50) not null,
password varchar(50),
new_role varchar(50),
message varchar(100));

insert into change_role values("admin","adminuser@12345","contributor","Changed roles.");


