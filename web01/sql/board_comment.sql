drop table board_comment;
drop sequence board_comment_seq;
create table board_comment(
	num number primary key,
	writer varchar2(30),
	wtime date,
	content varchar2(2000),
	ref number,
	no number,
	lev number
);
create sequence board_comment_seq;
--
insert into board_comment values (board_comment_seq.nextval,'admin1',sysdate,'내용없음',board_comment_seq.currval,0,0);