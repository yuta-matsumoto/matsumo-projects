drop database if exists tourticket;

create database if not exists tourticket;
use tourticket

drop table if exists ticket;

create table ticket(
ticket_id int(11) primary key auto_increment,
ticket_name varchar(255) unique,
price int(14),
stock int(14)
);


drop table if exists user_info;

create table user_info(
id int(11) Primary key auto_increment,
user_id varchar(255) unique,
user_pass varchar(255),
last_name varchar(255),
first_name varchar(255),
user_mail varchar(255),
gender enum('man','woman'),
birthday varchar(255),
user_ip varchar(255),
register_date timestamp,
update_date timestamp DEFAULT current_timestamp on update current_timestamp,
delete_date timestamp
);

drop table if exists user_address;

create table user_address(
user_id varchar(255) unique,
zipcode varchar(255),
prefecture varchar(255),
citytown varchar(255),
house_number varchar(255)
);

drop table if exists cart;

create table cart(
user_ip varchar(255),
mac_address varchar(255),
user_id varchar(255),
ticket_id int(11),
ticket_name varchar(255),
ticket_count int(14),
total_amount int(14),
token int(14)
);

drop table if exists history;

create table if not exists history(
user_id varchar(255),
ticket_id int(11),
ticket_count int(14),
total_amount int(14),
user_ip varchar(255),
order_day timestamp DEFAULT current_timestamp,
delete_day timestamp
);

INSERT INTO ticket(ticket_id,ticket_name,price,stock)VALUES(1,"test1",3000,5000);
INSERT INTO ticket(ticket_id,ticket_name,price,stock)VALUES(2,"test2",3000,5000);
INSERT INTO ticket(ticket_id,ticket_name,price,stock)VALUES(3,"test3",3000,5000);
INSERT INTO ticket(ticket_id,ticket_name,price,stock)VALUES(4,"test4",4000,5000);
INSERT INTO ticket(ticket_id,ticket_name,price,stock)VALUES(5,"test5",5000,5000);
INSERT INTO ticket(ticket_id,ticket_name,price,stock)VALUES(6,"test6",6000,5000);
INSERT INTO ticket(ticket_id,ticket_name,price,stock)VALUES(7,"test7",3000,5000);
INSERT INTO ticket(ticket_id,ticket_name,price,stock)VALUES(8,"test8",3000,5000);
INSERT INTO ticket(ticket_id,ticket_name,price,stock)VALUES(9,"test9",3000,5000);
INSERT INTO ticket(ticket_id,ticket_name,price,stock)VALUES(10,"test10",4000,0);

