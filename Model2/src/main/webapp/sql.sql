-- 1. Member 테이블 생성
-- id, pw, name -> varchar2(100)
-- id -> pk

drop table Member

create table Member (
	id varchar2(100),
	pw varchar2(100),
	name varchar2(100),
	constraint member_id_pk primary key(id)
	)


-- 2. test 값 넣어보기
insert into Member values('rlatndk2880', '123', '김수아');

-- 3. 조회하기
select * from Member;