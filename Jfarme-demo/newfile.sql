create database xie;

use xie;

create table user
(
 id int auto_increment primary key,
 username varchar(20),
 password varchar(20),
 root int
);

insert into user(username,password,root) values('xie','123',2);
insert into user(username,password,root) values('hui','789',4);
insert into user(username,password,root) values('tian','456',3);
insert into user(username,password,root) values('qin','ying',1);
select * from user;


select * from user where username='zhangsan2' and password='123456';

select count(*) from user where username='zhangsan2' and password='123456';

update user set username="lishi" where id=1

update user set password=111 where id=1;

------------------------------------------------------------------
create table thingmassage
(
 id int auto_increment primary key,
 thingId varchar(20),
 thingName varchar(20),
 shangjia varchar(20),
 jinjia varchar(20),
 shoujia varchar(20)
);

insert into thingmassage(thingId,thingName,jinjia,shangjia,shoujia) values('1234','辣条','3','奇果小店','4');
insert into thingmassage(thingId,thingName,jinjia,shangjia,shoujia) values('1235','面','5','奇果小店','7');
insert into thingmassage(thingId,thingName,jinjia,shangjia,shoujia) values('1236','粥','6','奇果小店','10');
select * from thingmassage;
------------------------------------------------------------
create table xiaodan
(
	id int auto_increment primary key,
	thingId varchar(20),
	number varchar(20),
	time varchar(20),
 	zhiyuan varchar(20)
);

insert into xiaodan(thingId,number,time,zhiyuan) values('1234','10','2016-7-5 21:54:02','qin');
insert into xiaodan(thingId,number,time,zhiyuan) values('1235','10','2016-7-5 21:54:02','qin');
select * from xiaodan;
-----------------------------------------------------------
create table jindan
(
	id int auto_increment primary key,
	thingId varchar(20),
	number varchar(20),
	time varchar(20),
 	zhiyuan varchar(20)
);
insert into jindan(thingId,number,time,zhiyuan) values('1234','100','2016-7-5 21:54:02','qin');
insert into jindan(thingId,number,time,zhiyuan) values('1235','100','2016-7-5 21:54:02','qin');
select * from jindan;
----------------------------------------------------------
create table kucun
(
	Id int auto_increment primary key,
	thingId varchar(20),
	number varchar(20)
);

insert into kucun(thingId,number) values('1234','100');
insert into kucun(thingId,number) values('1235','100');
insert into kucun(thingId,number) values('1236','50');

select * from kucun;


