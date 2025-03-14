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