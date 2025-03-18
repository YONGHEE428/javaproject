--테이블생성
create table sawon (num number(5) CONSTRAINT sawon_pk_num primary key,
name varchar2(20), gender varchar2(20),
buseo varchar2(20), pay number(10) default 1200000 ); 

--alter로 제약조건 추가가능(부서명: 개발부,교육부,디자인부)
alter table sawon add constraint sawon_ck_buseo check(buseo in ('개발부','교육부','디자인부'));


--제약조건추가: 남자 여자만 가능하다
alter table sawon add constraint ck_sawon_gender check(gender in ('남자','여자'));

--새로운시퀀스 
create sequence seq_sawon nocache;

--데이타 추가
insert into sawon values(seq_sawon.nextval, '박용희', '남자','교육부',2500000);
insert into sawon values(seq_sawon.nextval, '조태민', '남자','디자인부',3100000);
insert into sawon values(seq_sawon.nextval, '손흥민', '남자','개발부',4000000);
insert into sawon values(seq_sawon.nextval, '김연아', '여자','교육부',2800000);
insert into sawon values(seq_sawon.nextval, '박서준', '남자','교육부',2750000);
insert into sawon values(seq_sawon.nextval, '장원영', '여자','디자인부',3300000);
insert into sawon values(seq_sawon.nextval, '카리나', '여자','개발부',3900000);
insert into sawon values(seq_sawon.nextval, '김태형', '남자','디자인부',3600000);
insert into sawon values(seq_sawon.nextval, '손석구', '남자','개발부',5000000);
insert into sawon values(seq_sawon.nextval, '아이유', '여자','디자인부',3150000);


commit;
--수정
update sawon set buseo = '교육부';
rollback;


--여러컬럼 수정 40번 부서: 교육부, pay = 2800000
update sawon set buseo = '교육부', pay = 2800000 where num = 9;

--그룹함수 사용
--부서별 인운수와 최고급여, 최저급여 조회
select buseo, max(pay),min(pay) from sawon group by buseo;

--위에 결과에 화폐단위 붙히고 천단위 구분기호
select buseo 부서명, count(*) 인원수, to_char(max(pay), 'l999,999,999') 최고급여, to_char(min(pay), 'l999,999,999') 최저급여 from sawon group by buseo;


--뒤에 명 붙여보기
select buseo 부서명, count(*) || '명' 인원수 ,  to_char(max(pay), 'l999,999,999') 최고급여, to_char(min(pay), 'l999,999,999') 최저급여 from sawon group by buseo;

--성별 인원수와 평균급여, 최고급여, 최저급여구하기
select gender 성별, count(*)||'명' 인원수, to_char(avg(pay), 'l999,999,999') 평균급여,
to_char(max(pay), 'l999,999,999') 최고급여, to_char(min(pay), 'l999,999,999') 최저급여
from sawon group by gender;

--부서병 인원이 4명이상인 경우에만 출력
select buseo, count(*)  from sawon group by buseo having count(buseo) >=4;

--제약조건 제거
--sawon테이블의 sawon_ck_buseo를 제거해보기
alter table sawon drop constraint sawon_ck_buseo;

insert into sawon values (seq_sawon.nextval, '유승호', '남자', '홍보부',25000000);

--sawon에 name에 unique제약조건 추가
alter table sawon add constraint sawon_uk_name unique(name);

--name이 중복인 데이터 넣어보기
insert into sawon values (seq_sawon.nextval, '유승호', '여자', '개발부',25000000);

update sawon set pay = 2500000 where name = '유승호';
select * from emp;

--------------------------------------------------------------------------------------------------
--[JOIN]
--emp와 dept를 조인해서 emp사람들의 이름과 부서를 구하시오
--한쪽에만 존재하는 컬럼은 구분을 해줘도 안해줘도 상관없지만 양쪽에 있는 컬럼은 구분해야함
select ename, e.deptno ,dname  from emp e, dept d
where e.deptno =d.deptno;

--professot + department 조인하여 다음과 같이 조회\
--교수명 학과명 급여를 조회
select name, d.deptno,dname from professor p, department d
where p.deptno = d.deptno;

--emp에 dept에 없는 deptno를 삽입하거나  null로 인서트 해보자
insert into emp(empno,ename,job,mgr,sal)values(7937,'KIM','MANAGER',7902,1200);
insert into emp(empno,ename,job,mgr,sal)values(7973,'LEE','MANAGER',7986,1200);

--조인
select e.ename,d.dname from emp e, dept d where e.deptno = d.deptno;

--lee와 kim이 조인에서 조회가 안된다 만약 null까지 조회하고 싶다면 outer join해야한다
select e.ename,d.dname from emp e, dept d where e.deptno = d.deptno(+);

select studno 학번, name 이름, grade 학년, dname 전공 from student s, department d
where d.deptno = s.deptno1;


--panmae + prodoct
--입고날짜 상품명 상품가격 입고갯수
select p_date 입고날짜, p_name 상품명, p_price 상품가격, p_qty 입고갯수, p_total 총가격
from panmae, product
where panmae.p_code = product.p_code;

--[조인 연습용 테이블 생성하기]

create table food(foodnum number(3)primary key,
foodname varchar2(20), foodprice number(7), foodsize varchar2(20));

create table booking(bnum number(3)constraint pk_booking_bnum primary key,
bname varchar2(20) constraint nn_booking_bname not null, bhp varchar2(20) constraint uq_booking_bhp unique,
foodnum number(3), bday date, constraint fk_foodnum foreign key(foodnum) references food(foodnum));

--food테이블에 메뉴등록
insert into food values(100,'짜장면',9000,'보통');
insert into food values(101,'짬뽕',9500,'보통');
insert into food values(102,'탕수육',10000,'소짜');
insert into food values(103,'양장피',15000,'중짜');
insert into food values(104,'짬뽕',11500,'곱빼기');
insert into food values(105,'짜장면',10000,'곱빼기');
insert into food values(106,'탕수육',15000,'중짜');
insert into food values(107,'유린기',20000,'중짜');

commit;

--시퀀스 생성
create sequence seq_food start with 10 increment by 10 nocache;

--예약
--메뉴에 없는 foodnum을 입력하면 부모키가 없다는 제약조건위배가 나온다
insert into booking values(seq_food.nextval, '박용희' , '010-1234-5243', 100, sysdate);
insert into booking values(seq_food.nextval, '조태민' , '010-2131-5464', 100, sysdate);
insert into booking values(seq_food.nextval, '박서준' , '010-7891-1562', 101, sysdate);
insert into booking values(seq_food.nextval, '장원영' , '010-1951-3021', 105, sysdate);
insert into booking values(seq_food.nextval, '이연복' , '010-8523-7452', 103, sysdate);
insert into booking values(seq_food.nextval, '카리나' , '010-5232-7654', 106, sysdate);

--inner join으로 예약손님 주문정보 확인
--주문자 이름, 주문자전화번호, 음식이름, 음식가격, 음식사이즈, 주문한날짜
select bname 주문자이름, bhp 주문자전화번호, f.foodnum 주문번호, foodname 음식이름, foodprice 음식가격, foodsize 음식사이즈, bday 주문한날짜 from food f , booking b
where f.foodnum = b.foodnum;

--outer_join을 이용해서 한번도 주문하지 않은 메뉴 알아보기
select f.foodnum,bname,foodname,foodprice,foodsize
from food f, booking b
where f.foodnum =b.foodnum(+);

--위에 sql통해서 주문자 이름 빼고  null인경우만 출력하면 아무도 주문하지 않은 메뉴만 골라낼 수 있다.
select f.foodnum,foodname,foodprice,foodsize
from food f, booking b
where f.foodnum=b.foodnum(+) and bname is null;

--booking(자식테이블) 에 추가된 메뉴를 food(부모테이블)에서 삭제할 수 있을까
--자식테이블 생성시 onm delete cascade 설정을 안했을 경우 못지운다
delete from food where foodnum = 101; --booking테이블에서 주문이 되어있으므로 101번은 못지운다.

--아무도 주문하지 않은 104번 지우기
delete from food  where foodnum =104;

--부모테이블 삭제
drop table food; -- 자식테이블이 먼저 삭제되어야 부모테이블 삭제 가능

--booking 먼저 지우고 food 삭제 순으로 가야한다
drop table booking;
drop table food;

--sequence도 삭제
drop sequence seq_food;


select * from booking; 
select * from food;

--정규화
--한마디로 DB서버의 메모리를 낭비하지않기위해서
--어떤 테이블의 식별자를 가지는 여러개의 테이블로 나누는 과정
--정규화된 테이블으 중복이 최소화되도록 설계하는 데이타베이스

--수업과정
--1. 일단 비정규화 테이블_ 데이타를 추가하고 조회
--2. 1번을 2개으 테이블로 나누어서 외부키를 이용하여 연결
--3. 데이타 삭제시 정규화된 테이블의 경우 문제가 발생
--4. cascade연산자를 이용해서 다시한번 테이블을 생성해보고 삭제 연습


--비졍규화 테이블
--회사직원테이블 : companysawon
--회사명 : company 문자열(10)
--회사주소 : address 문자열(20)
--회사 전화 : phone 문자열(15)
--직원명 : sawon_name 문자열 (15)
--직급 : position 문자열(10)
--이메일 : email 문자열 (20)
--휴대폰 : hp 문자열 (20)

create table companysawon(company varchar2(10), address varchar2(20), phone varchar2(15),
sawon_name varchar2(10), position varchar2(10), email varchar2(20), hp varchar2(20));

insert into companysawon values ('LG','서울시 강남구','02-124-5565','홍길동','사원','hkd@naver.com','010-1245-7654');
insert into companysawon values ('KT','서울시 역삼동','02-176-2145','김선동','대리','fsd@naver.com','010-1765-8254');

--거래처 회사에 대한 정보 : 거래처 직원을 추가할때마다 매번 추가
--메모리 낭비가 심하다
--만약 회사 이전 또는 승진등 정보가 변경되면 많은 데이타를 한꺼번에 수정해야한다
--정규화된 테이블정보로 수저이 필요한 것

--2.정규화된 데이타 정보로 수정
--회사테이블 : company
--회사아이디 : company_id number(5) 기본키
--회사명 : 
--회사주소 : 
--회사 전화 : 


--사원테이블 : sawon
--직원명 : 
--직급 : 
--이메일 :
--휴대폰 : 
--회사아이디 : 외부키

--부모테이블
create table company (company_id number (5) primary key,
company varchar2(20), address varchar2(20), phone varchar2(20));

--데이타 추가
INSERT into company values(10, 'KT','경기도 분당구','02-632-1245');
INSERT into company values(20, 'LG','서울시 을지로','02-135-7435');
INSERT into company values(30, '삼성','경기도 용인시','02-698-2626');

--자식테이블
create table sawon2 (company_id number(5), sawon_name varchar2(20),
position varchar2(20), email varchar2 (20), hp varchar2(20),
constraint sawon_fk_id foreign key(company_id) REFERENCES company(company_id));

--cascade
--자식테이블
create table sawon3 (company_id number(5), sawon_name varchar2(20),
position varchar2(20), email varchar2 (20), hp varchar2(20),
constraint sawon_fk_id foreign key(company_id) REFERENCES company(company_id)
on delete cascade--자식이 있는 부모글을 삭제할 수 있고 삭제하면 해당 자식들 한번에 삭제);




select * from company;
select * from companysawon;




































rollback;