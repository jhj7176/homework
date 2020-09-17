drop table dataroom;
drop sequence dataroom_seq;

create sequence dataroom_seq;
create table dataroom(
	drNum number primary key,
	drTitle varchar2(200) default '제목없음',
	num number,
	drDate date,
	fileName varchar2(300),
	drContent varchar2(2048),
	foreign key(num) references member(num)
);

insert into dataroom values (dataroom_seq.nextval,'공지사항',2221,sysdate,null,'공지사항입니다');
insert into dataroom values (dataroom_seq.nextval,'공지사항2',2222,sysdate,null,'공지사항입니다2');
insert into dataroom values (dataroom_seq.nextval,'공지사항3',2221,sysdate,null,'공지사항입니다3');

select * from dataroom;
delete from dataroom where drnum=4;

select drNum,drTitle,name,drdate,fileName,drContent from dataroom, member where member.num=dataroom.num and drNum=1
update dataroom set drTitle='test3',drContent='test2' where drNum=5;
update dataroom set fileName=null where drNum=13;

select * from (select rownum as rwn,drNum,drTitle,name,drdate,fileName,drContent from dataroom,member
where member.num=dataroom.num and dataroom.num=2221 order by drNum desc);

select rownum from dataroom where num=2221 order by drNum desc;


select count(*) as total from (select rownum from dataroom, member where member.num=dataroom.num and dataroom.num=2221);

select num from member where lecture='정보처리기사 취득과정' and lvl=3;

select * from (select rownum as rwn,drNum,drTitle,name,drdate,fileName,drContent from (select * from dataroom,member 
where member.num=dataroom.num and dataroom.num=(select num from member where lecture='정보처리기사 취득과정' 
and lvl=3) order by drNum desc)) where rwn between 1 and 10

select drNum,drTitle,name,drdate,fileName,drContent,rownum from (select drNum,drTitle,name,drdate,fileName,drContent from dataroom,member where member.num=dataroom.num and dataroom.num=2221 order by drNum desc) where rownum between 1 and 10; 

select rownum as rwn,drNum,drTitle,name,drdate,fileName,drContent from dataroom,member where member.num=dataroom.num and dataroom.num=2221 order by rwn desc;

select * from (select rownum as rwn,drNum,drTitle,name,drdate,fileName,drContent from (select * from dataroom,member where member.num=dataroom.num and dataroom.num=2221 order by drNum desc)) where rwn between 1 and 10;

select count(*) as total from (select rownum from dataroom, member where member.num=dataroom.num and dataroom.num=(select num from member where lecture='정보처리기사 취득과정' and lvl=3))

