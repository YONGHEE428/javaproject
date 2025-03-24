create sequence seq_food start with 1 increment by 3 nocache;

create table foodmenu (fno number(5) primary key, food_name varchar2(20),
price number(10), shop_name varchar2(20), loc varchar2(20));

ALTER TABLE foodmenu MODIFY shop_name varchar2(30);

insert into foodmenu values ( seq_food.nextval, '알리오올리오', 15000,'쏘렌토','역삼역 2번출구');
insert into foodmenu values ( seq_food.nextval, '치즈돈까스', 9000,'맛나 돈까스','역삼역지하상가');
insert into foodmenu values ( seq_food.nextval, '순대국', 10000,'왕할머니순대국','강남역1번출구');
insert into foodmenu values ( seq_food.nextval, '짜장면', 8000,'칭따오','역삼역4번출구');
insert into foodmenu values ( seq_food.nextval, '부대찌개', 11000,'왕대박부대찌개','강남역3번출구');
insert into foodmenu values ( seq_food.nextval, '제육덮밥', 9500,'할머니손맛백반','선릉역2번출구');
insert into foodmenu values ( seq_food.nextval, '빅맥세트', 8500,'맥도날드','선릉역4번출구');

create table foodorder (no number(5),order_name varchar2(20), fno number(5),addr varchar2(20), 
CONSTRAINT foodorder_fk_fno foreign key(fno) references foodmenu(fno)on delete cascade);


insert into foodorder values (seq_food.nextval, '박용희',1,'역삼동');
insert into foodorder values (seq_food.nextval, '조태민',10,'강남역');
insert into foodorder values (seq_food.nextval, '아이유',25,'선릉역');
insert into foodorder values (seq_food.nextval, '손흥민',28,'역삼역');


select foodorder.fno 주문번호, order_name 주문자, food_name 음식명, price 가격, shop_name 상호명, loc 가게위치, addr 주문자주소
from foodmenu,foodorder
where foodmenu.fno = foodorder.fno;
select * from foodorder;
select * from foodmenu;
