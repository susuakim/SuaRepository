select * from book_member

create table book_member
(id varchar2(50),pw varchar2(50) not null, nick varchar2(50),
email varchar2(50),tel varchar2(50),
constraint book_member_id_pk primary key(id))

insert into book_member(id,pw,nick,email,tel)
values('test',1234,'test','test',01012345678);

select *from BOOK_MEMBER

commit