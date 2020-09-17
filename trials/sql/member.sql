drop table member;

create table member(						
	num number primary key, 				--ȸ����ȣ
	id_email varchar2(50) unique not null,  --�̸����� ���̵�ξ�
	name varchar2(15),						--ȸ���̸�
	lvl number(1) default 1,				--���
	password varchar2(15) not null, 		--��й�ȣ ����+��������
	phone number,							--��ȭ��ȣ
	lecture varchar2(30),					--���¸� 
	foreign key(lvl) references bitjejudept(lvl) on delete cascade
);

select * from MEMBER;

insert into member values (1111, 'tmsisj@email.com','����',6,'tmsisj',01012341234,'');
insert into member values (2222, 'sales@email.com','�̿���',4,'password',01012341234, null);
insert into member values (3333, 'staff@email.com','������',5,'password',01012341234, null);
insert into member values (4444, 'teacher@email.com','�迵��',3,'password',01012341234, null);
insert into member values (5555, 'test@email.com','���Ϲ�',1,'password',01012341234, null);

insert into member values (6666, 'text1@email.com','철수',2,'password',01012341234,'산업기사취득과정A');
insert into member values (7777, 'text4@email.com','영희',2,'password',01012341234,'산업기사취득과정A');
insert into member values (8888, 'text3@email.com','짱구',2,'password',01012341234,'산업기사취득과정A');

commit

delete from member;
