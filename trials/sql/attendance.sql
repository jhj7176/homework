drop table attendance;

create table attendance( --�⼮���̺�
	nalja date not null,
	num number,
	state varchar2(15), --�⼮ ���� �Ἦ ����
	foreign key(num) references member(num) on delete cascade --foreign key����. member���̺� num����
);

select * from ATTENDANCE;

insert into attendance values('2020-08-04',6666,'�⼮');
insert into attendance values('2020-08-04',7777,'�⼮');
insert into attendance values('2020-08-04',8888,'�Ἦ');

commit;

delete from ATTENDANCE;

select * from attendance;

select nalja, attendance.num,name,state from attendance,member where attendance.num=member.num 
and lecture=(select lecture from member where num=2221) and nalja='2020-08-19' order by nalja desc, num asc

select count(*) as total from (select rownum from attendance, member where attendance.num=member.num 
and lecture=(select lecture from member where num=2221))

select nalja from attendance where num=6666 and state='조퇴';

select * from (select rownum as rwn,drNum,drTitle,name,drdate,fileName,drContent from (select * from dataroom,member 
where member.num=dataroom.num and dataroom.num=? order by drNum desc)) where rwn between 1 and 10

select * from (select rownum as rwn nalja, attendance.num,name,state from attendance,member where 
attendance.num=member.num and lecture=(select lecture from member where num=?) order by nalja desc, num asc) where rwn between 1 and 10











