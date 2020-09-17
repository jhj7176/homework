drop table attend;
drop table member;
create table member(
	id varchar2(30) primary key,
	password varchar2(30) not null,
	lvl number(1)
);

insert into member values ('master','master',3);
insert into member values ('guest','guest',1);
insert into member values ('tmsisj','qlxm1234',2);

commit

select * from member;