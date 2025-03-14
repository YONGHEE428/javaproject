--where절
--산술연산자
select * from emp;
--사원명,급여,특별보너스(급여+100)을 조회하시오
select ename 사원명, sal as 급여, sal+100"특별보너스" from emp;
--급여가 3000이상사람의 이름과 급여 조회
select ename 이름, sal 급여 from emp where sal >=3000;
--사원명이 스코트인 사람의 사원번호,급여를 조화ㅣ하시오
select empno 사원번호, sal 급여 from emp where ename ='SCOTT';
--where절이용 Student테이블
select * from student;
--학생중 키가  170이상인 학생의 학번과 이름과 키를 조회하시오
select studno 학번, name 이름 ,height 키 from student where height >=170;
--between, in
--in연산자
--depno1이 101 102인 학생명,학년
select name 이름, grade 학년, deptno1 from student where deptno1 in(101, 102);
--몸무게가 60~80사이인 학생의 이름, 몸무게 조회
select name 이름, weight 몸무게 from student where weight between 60 and 80;

--Like연산자 // 특정 문자 포함 구문 찾기
--성이 김씨인 학생의 이름과 학년을 조회하시오.
select name , grade from student where name like '김%';

--professor에서 보너스가 null값인 교수명만 출력 (is문)
select name,bonus from professor where bonus is null;

--professor에서 보너스가 null값이 아닌 교수명만 출력 (is not문)
select name,bonus from professor where bonus is not null;

select * from emp;

--nvl
select empno, nvl(comm,0) "nvl입니다." from emp where deptno=30;

--emp에서 급여, 급여*12, comm
select sal 급여, sal*12 연봉, comm , sal*12+nvl(comm,0) 총급여 from emp;

--emp에서 급여가 1500이상 4000이하 인사람의 사원번호 사원명 급여
select empno 사원번호, ename 사원명 from emp where sal between 1500 and 4000;

--입사일이 1981/01/01과 1981/12/31사이에 입사한 사람의 이름과 급여
select ename 사원명, sal 급여 from emp where hiredate between '1981/01/01' and '1981/12/31';

--직업이 manager,analyst,clerk인 사람의 사원명,직업을 구하시오
select ename 사원명, job 직업 from emp where job in('MANAGER', 'ANALYST', 'CLERK');
--학생테이블에서 이름이 수로 끝나는 사람의 이름과 학년을 구하시오
SELECT name 이름 , grade 학년 from student where name like '%수';

--2번째 이름의 A가 들어가는 사람의 사번,이름,입사일,급여
select empno 사번, ename 이름, hiredate 입사일, sal 급여 from emp where ename like '_A%';

--And Or
--직업이 manager이고 부서번호가 10번인 사원의 사번,사원명,직업,부서번호를 조회하시오
select empno,ename,job,deptno from emp where job = 'MANAGER' and deptno = 10;

--입사일이 82/01/01 이전에 입사했거나 직업이 manager 사원의 사번, 사원명,직업,입사일
select empno, ename, job, hiredate from emp where hiredate <='1982/01/01' or job = 'MANAGER';

--다중정렬
--직업의 오름차순, 급여의 내림차순 정렬  (작은거에서 큰걸로 asc, 큰거에서 작은걸로 desc)
select ename , job, sal from emp order by job ,sal desc;

--학생테이블에서 1학년학생의 이름과 키와 몸무게를 구하시오. 단 키는 작은사람붗터, 몸무게는 큰사람부터
select name, height, weight from student order by height , weight desc;

--학생테이블에서 몸무게  80d이상인 학생명,학년,키,몸무게를 조회하되 4학년부터1학년순서로 조회한후 몸무게가 적은사람부터 조회할것
select name,grade,height,weight from student where weight >= 80 order by grade desc, weight desc;
--학생테이블에서 생일이 1975/01/01이후인 학생의 학생명,학년,생일을 조회하되 생일의 내림차순조회하시오
select name,grade,birthday from student where birthday > '1975/01/01' order by birthday desc;

--between, in, and, or
--급여가 1200~2000사이의 이름,급여,보너스를 구하시오
select ename, sal, comm from emp where sal >= 1200 and sal <=2000;
--급여가 1200~2000사이의 이름,급여,보너스를 구하시오
select ename, sal, comm from emp where sal between 1200 and 2000;
--job이 MANAGER,SALESMAN인 사람의 이름과 직업을 구하시오
select ename, job from emp where job = 'MANAGER' or job ='SALESMAN';
--job이 MANAGER,SALESMAN인 사람의 이름과 직업을 구하시오
select ename, job from emp where job in('MANAGER','SALESMAN');

--union 두 결과값에서 중복된값 제거후 출력
--union all 중복값까지 출력
select * from student;
select name from student where deptno1 = 103 union select name from student where deptno2=203;
select name from student where deptno1 = 103 union all select name from student where deptno2=203;

--교집합 intersect
select name from student where deptno1 = 101 INTERSECT select name from student where deptno2 = 201;

--단일함수
--Count
select * from professor;
select count(*), count(hpage) from professor;

--sum
select count(bonus), sum(bonus) from professor;

--avg
select count(bonus), sum(bonus), avg(bonus) from professor;

--max,min
select max(sal), min(sal) from emp;
select max(hiredate), min(hiredate) from emp;

--그룹함수
--emp의 전체 갯수
select count(*) from emp;
--급여의 평균
select avg(sal) from emp;

select round(avg(sal),2) from emp;
select round(avg(sal),3) from emp;
select round(avg(sal),0) from emp;

select round(avg(sal),-1) from emp;
select round(avg(sal),-2) from emp;

--to_char .. date형 number형을 varchar2로 바꿔준다ㅣ
--현재날짜를 콘소에 출력 sysdate (dual)
select sysdate+1 from dual;

--날짜에서 월만 출력(3월)
select to_char(sysdate,'month')from dual;
--날짜에서 월만 출력 (03)
select to_char(sysdate,'mm')from dual;

--날짜와 시간 출력
select to_char(sysdate,'YYYY-mm-dd hh24-mi-ss')from dual;

--to_char number형 숫자에도 적용가능
select to_char(4578952,'999,999,999')from dual;
select to_char(54.9,'09999.90')from dual;


--오전복습문제
--1.표현식을 이용하여 smith(clerk)로 조회하시오
select * from emp;
select  ename || '(' || job || ')' 이름 from emp where ename = 'SMITH' and job = 'CLERK';
--2. professor - 이름,급여,보너스,총급여 로 조회하시오.
select name,pay,bonus,pay+nvl(bonus,0) 총급여 from professor;
--3. 고객테이블에서 포인트가 50만 이상인 사람의 이름 주민번호 포인트 조회하시오.
select gname 이름, jumin 주민번호, point 포인트 from gogak where point >= 500000;
--student에서 이름이 서진수인 학생의 이름 학년 전화번호
select name 이름, grade 학년, tel 전화번호 from student where name='서진수';
--gogak에서 포인트가 30만에서 50만 사이인 고객의 이름 포인트를 포인트 내림차순로 
select gname 이름, point 포인트 from gogak where point between 300000 and 500000 order by point desc ;
--student에서 김씨 또는 이씨의 이름 학번 학년
select name 이름, studno 학번, grade 학년 from student where name like '김%' or name like '이%';
--student에서 4학년이며,몸무게가 60이상이거나 키가170미만인 학생의 이름 학년 키 몸무게
select name 이름, grade 학년, height 키, weight 몸무게 from student where grade = 4 and (height < 170 or weight >60);
--emp에서 직업이 manager인 사람의 이름과 보너스 null은 0으로
select ename 이름, nvl(comm,0) 보너스 from emp where job = 'MANAGER';
--emp에서 직업 오름차순, 총연봉내림차순 이름 급여 연봉 보너스 총연봉
select ename 이름, sal 급여, sal*12 연봉,comm 보너스, sal*12 + nvl(comm,0) 총연봉 from emp order by job, sal*12 desc;
--student에서 3학년중 이름 키 학년 이름 오름차순
select name 이름, height 키 , grade 학년 from student where grade = 3 order by name asc;
--emp에서 5월에 입사한 사람의 이름과 입사일
select ename 이름, hiredate 입사일 from emp where hiredate like '____5%'; 
select ename,hiredate from emp where to_char(hiredate,'mm') ='05';
--이름의 미가 포함된 사람
select name ,grade from student where name Like '%미%';
--사워중 n을 포함하고 있는데이터 출력
select ename,job,sal from emp where lower(ename) like '%n%';

--[서브쿼리] 쿼리안에 또다른 쿼리문이 담김
--smith보다 급여를 많이 받는 사람
--select 컬럼1,컬럼2 from emp where 조건연산자 (select 컬럼명 from 테이블 where 조건);
select * from emp;
select ename, sal
from emp 
where sal > (select sal from emp where lower(ename) ='smith');


select name 학생명, grade 학년, height 키
from student
where height < (select height from student where name = '서진수'); 

select name 학생명, weight 몸무게
from student
where weight > (select avg(weight) from student where deptno1 = 101);

select * 
from emp
where sal > (select avg(sal) from emp);

select *
from emp
where mgr = (select mgr from emp where lower(ename) = 'allen') and lower(ename) != 'allen'; 

select profno 번호, name 이름, pay 급여
from professor
where pay < (select avg(pay) from professor where position = '정교수');

select name 이름, ID 아이디, height 키
from student
where height < (select avg(height) from student where grade = '1');

select deptno "deptno", ename 이름
from emp
where deptno in (select deptno from emp where lower(ename) like 's%');