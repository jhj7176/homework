drop table grade;

create table grade(  			--성적테이블
	num number primary key,		--회원번호로 누군지 식별함. 멤버테이블 num참조
	exam1 number,				--시험성적
	exam2 number,
	exam3 number,
	foreign key(num) references member(num) on delete cascade
);

select * from grade;

insert into grade(num,exam1) values(6666, 100);
insert into grade(num,exam1,exam2) values(7777, 80,90);
insert into grade values(8888, 90,70,100);


update grade set exam3=77 where num=6666;


delete from grade;

commit