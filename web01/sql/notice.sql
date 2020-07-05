drop table notice;
drop sequence notice_seq;
create table notice(
	num number primary key,
	title varchar2(30) not null,
	writer varchar2(30),
	wtime date,
	content varchar2(2000),
	ref number,
	no number,
	lev number,
	etime date
);
create sequence notice_seq;
--
insert into notice (num, title, writer, wtime, content, ref, no, lev) values (notice_seq.nextval,'test1','admin1',sysdate,'내용없음',notice_seq.currval,0,0);
insert into notice (num, title, writer, wtime, content, ref, no, lev) values (notice_seq.nextval,'test2','admin1',sysdate,'내용없음',notice_seq.currval,0,0);
insert into notice (num, title, writer, wtime, content, ref, no, lev) values (notice_seq.nextval,'test3','admin1',sysdate,'내용없음',notice_seq.currval,0,0);
insert into notice (num, title, writer, wtime, content, ref, no, lev) values (notice_seq.nextval,'test4','admin1',sysdate,'내용없음',notice_seq.currval,0,0);
insert into notice (num, title, writer, wtime, content, ref, no, lev) values (notice_seq.nextval,'test5','admin1',sysdate,'내용없음',notice_seq.currval,0,0);
insert into notice (num, title, writer, wtime, content, ref, no, lev) values (notice_seq.nextval,'test6','admin1',sysdate,'내용없음',notice_seq.currval,0,0);
insert into notice (num, title, writer, wtime, content, ref, no, lev) values (notice_seq.nextval,'test7','admin1',sysdate,'내용없음',notice_seq.currval,0,0);
insert into notice (num, title, writer, wtime, content, ref, no, lev) values (notice_seq.nextval,'test8','admin1',sysdate,'내용없음',notice_seq.currval,0,0);
insert into notice (num, title, writer, wtime, content, ref, no, lev) values (notice_seq.nextval,'test9','admin1',sysdate,'내용없음',notice_seq.currval,0,0);
insert into notice (num, title, writer, wtime, content, ref, no, lev) values (notice_seq.nextval,'test10','admin1',sysdate,'내용없음',notice_seq.currval,0,0);
insert into notice (num, title, writer, wtime, content, ref, no, lev) values (notice_seq.nextval,'test11','admin1',sysdate,'내용없음',notice_seq.currval,0,0);

commit;