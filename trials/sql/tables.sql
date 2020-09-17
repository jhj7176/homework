drop table grade;
drop table board2;
drop table lectures;
drop table attendance;
drop table member;--member테이블의 num을 다른데서 참조하므로 항상 drop을 마지막에 해줘야함
drop table bitjejudept;
drop sequence member_seq;
drop sequence lectures_seq;


create table bitjejudept(
	dept varchar2(20) primary key,
	lvl number unique not null
);
--부서와 권한레벨을 가진 테이블, 6개의 부서로 나뉜다. 

insert into bitjejudept values ('일반회원',0);
insert into bitjejudept values ('수료생',1);
insert into bitjejudept values ('수강생',2);
insert into bitjejudept values ('강사',3);
insert into bitjejudept values ('영업',4);
insert into bitjejudept values ('행정',5);
insert into bitjejudept values ('관리자',6);

select * from bitjejudept;

create sequence member_seq;
create table member(					
	num number primary key, 			
	id_email varchar2(50) unique not null,
	name varchar2(15),					
	lvl number(1) default 0,			
	password varchar2(15) not null, 	
	phone varchar2(15),					
	lecture varchar2(50),					
	foreign key(lvl) references bitjejudept(lvl)
);

commit

select count(*) as total from member where lvl<3;
select member.num,name,lecture,start_day,lvl from member, lectures where member.lecture=lectures.lecture_name and lvl<3 ;

select * from MEMBER;
select * from member where dept='수강생';

insert into member values (1111, 'tmsisj@email.com','형진',6,'tmsisj','01012341234','');
insert into member values (1234, 'sales@email.com','이영업',4,'password','01012341234', null);
insert into member values (4321, 'staff@email.com','김행정',5,'password','01012341234', null);
insert into member values (2221, 'teacher@email.com','김영조',3,'password','01012341234', null);
insert into member values (3333, 'test@email.com','일반',1,'password','01012341234', null);

insert into member values (4444, 'text2@email.com','철수2',2,'password','01012341234','JAVA');

insert into member values (2222,'teacher4@email.com','설민석',3,'password','01012341235',null);
insert into member values (2223,'teacher5@email.com','황현필',3,'password','01012341235',null);
insert into member values (2224,'teacher6@email.com','정민재',3,'password','01012341235',null);

insert into member values (6666, 'text1@email.com','철수',2,'password',01012341234,'산업기사취득과정A');
insert into member values (7777, 'text4@email.com','영희',2,'password',01012341234,'산업기사취득과정A');
insert into member values (8888, 'text3@email.com','짱구',2,'password',01012341234,'산업기사취득과정A');

insert into member values (6661, 'text5@email.com','김하나',0,'password','01012341234','정보처리기사 취득과정');
insert into member values (7771, 'text6@email.com','김둘',0,'password','01012341234','정보처리기사 취득과정');
insert into member values (8881, 'text7@email.com','김셋',0,'password','01012341234','정보처리기사 취득과정');

select lecture_name,start_day,end_day,lecture_room,name from member full outer join lectures on 
member.num=lectures.num where lecture_name = (select lecture from member where num = 6661)

select lecture_name,start_day,end_day,lecture_room from lectures where lecture_name = (select lecture from member where num = 6661)

select count(*) as stu from (select rownum from member where lecture=(select lecture from member where num=2221))


update member set lecture='정보처리기사 취득과정' where num=2221;
update member set lvl=2 where num=6661;

delete from member where lvl=2;

create table attendance( --출석테이블
	nalja date not null,
	num number,
	state varchar2(10), --출석 지각 결석 조퇴
	foreign key(num) references member(num) on delete cascade --foreign key지정. member테이블 num참조
);

insert into attendance values('2020-08-04',6661,'출석');
insert into attendance values('2020-08-04',7771,'출석');
insert into attendance values('2020-08-04',8881,'결석');
insert into attendance values('2020-08-05',6661,'지각');
insert into attendance values('2020-08-05',7771,'지각');
insert into attendance values('2020-08-05',8881,'지각');
insert into attendance values('2020-08-06',6661,'결석');
insert into attendance values('2020-08-06',7771,'결석');
insert into attendance values('2020-08-06',8881,'결석');
insert into attendance values('2020-08-16',6661,'출석');
insert into attendance values('2020-08-16',7771,'출석');
insert into attendance values('2020-08-16',8881,'출석');

delete from attendance;

commit;

select * from attendance;


create table grade(  			--성적테이블
	num number primary key,		--회원번호로 누군지 식별함. 멤버테이블 num참조
	exam1 number,				--시험성적
	exam2 number,
	exam3 number,
	foreign key(num) references member(num) on delete cascade
); 

insert into grade values(6666,77,80,90);
insert into grade values(7777,100,80,90);
insert into grade values(8888,65,80,90);

select * from grade;

create sequence lectures_seq;
create table lectures(								--강좌테이블
	lecture_name varchar2(50),			--강좌명
	start_day date,									--교육기간
	end_day date,
	num number,										--회원번호/./담당강사의 회원번호가 들어감
	lecture_room number,							--강의실번호
	lecture_num number  primary key,
	foreign key(num) references member(num) on delete cascade
);

select lecture from member where num=2221;

select member.num,exam1,exam2,exam3, name from grade full outer join member on grade.num=member.num where lvl=2

insert into lectures values ('산업기사취득과정A',sysdate,sysdate,2222,401,lectures_seq.nextval);
insert into lectures values ('UI/UX 개발자 과정',sysdate,sysdate,2223,401,lectures_seq.nextval);
insert into lectures values ('안드로이드 개발자 과정',sysdate,sysdate,2234,401,lectures_seq.nextval);

insert into lectures values ('정보처리기사 취득과정','2020-09-01','2020-11-30',2222,401,lectures_seq.nextval);
insert into lectures values ('백앤드 개발자 과정','2020-11-01','2021-1-31',2223,401,lectures_seq.nextval);
insert into lectures values ('프론트앤드 개발자 과정','2020-10-01','2020-12-31',2224,401,lectures_seq.nextval);


create table recruit (--모집공고게시판>>select * from lecture;>>모집공고 업로드하는 form>> 입력>>리쿠르트테이블에 insert
		
);
--영업사원>>반배정 메뉴 누르면>> 수강신청생 목록 >>select * from member where lvl<=1 and lecture is not null;
--일반회원 lvl = 0
--수료생 --lvl =1
--수강신청버튼은 레벨이 0인 회원만 누를수있다.
--일반회원이 수강신청 버튼 눌렀을 , update member set lecture = '신청한강좌명' where num<=1(수료생or일반회원)


--예전날짜로 출석체크 업데이트했을때// 오늘날짜로 넘어감. 


create table board2(									--기본적인 게시판 테이블
	num number primary key,
	title varchar2(100) not null,
	writer varchar2(50) not null,
	wtime date,
	content varchar2(3000),
	ref number,
	serial number,
	lev	number,
	filename varchar2(255)
);



select member.num, name,lecture_name,start_day,lvl from member,lectures where member.lecture=lectures.lecture_name and lvl<3 and lecture_num=7;















