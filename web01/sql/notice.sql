drop table notice;
drop sequence notice_seq;
create table notice(
	num number primary key,
	title varchar(30) not null,
	writer varchar(30),
	wtime date,
	ref number,
	no number,
	lev number
);
create sequence notice_seq;
--
insert into notice values (notice_seq.nextval,'test','admin1',sysdate,notice_seq.currval,0,0);
insert into notice values (notice_seq.nextval,'test','admin2',sysdate,notice_seq.currval,0,0);
insert into notice values (notice_seq.nextval,'test','admin3',sysdate,notice_seq.currval,0,0);
insert into notice values (notice_seq.nextval,'test','admin4',sysdate,notice_seq.currval,0,0);
insert into notice values (notice_seq.nextval,'test','admin5',sysdate,notice_seq.currval,0,0);
insert into notice values (notice_seq.nextval,'test','admin6',sysdate,notice_seq.currval,0,0);
insert into notice values (notice_seq.nextval,'test','admin7',sysdate,notice_seq.currval,0,0);
commit;