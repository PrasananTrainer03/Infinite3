select * from emptest

select * from emptest

select * from emptest where basic > 20000

select nam,basic from emptest

select 'Name of the Employee'=nam,'Basic is '=basic from
emptest

select empno,nam,basic-1200 'Cash on Hand',basic from emptest
select * from emptest

select nam,basic from emptest where 
empno<>1

select dept,nam,basic from emptest where dept='web' or dept='asp'

select dept,nam,basic from emptest
 where dept='web' or not dept='java'

select dept,nam,basic from emptest where 
basic not between 20000 and 40000

select * from emptest
select nam,basic from emptest where dept in('java','asp')

select empno,nam,basic from emptest where 
desig in('HR','Manager')

select empno,nam,basic from emptest where 
nam like 's%'

select empno,nam,basic from emptest where 
nam like 'p%'

select empno,nam,basic from emptest where 
nam like 's__t%'

select * from emptest

select * from emptest order by nam

select * from emptest order by basic desc

select top 3 * from emptest order by basic desc

select dept from emptest

select distinct dept from emptest

select 'ASCII CODE'=ascii('A')

select 'Char Value is '=char(65)

select charindex('E','HELLO')

select difference('HELLO','hello')

select difference('WELCOME','wel')

select left('satish',4)

select right('welcome',5)

select len('welcome')

select reverse('prasanna')

select substring('prasanna',2,3)

select lower('PRASANNA')

select upper('prasanna')

select nam from emptest

select 'Names are '=upper(nam) from emptest

select getdate()

select reverse('prasanna')

select datename(mm,getdate())

select datepart(mm,getdate())
select datepart(dd,getdate())

select datepart(yy,getdate())

select datepart(qq,getdate())

select datepart(dy,getdate())

select datepart(y,getdate())

select datepart(wk,getdate())

select datepart(dw,getdate())

select datename(mm,getdate())

select datename(dw,getdate())

select dateadd(mm,-3,getdate())

select dateadd(mm,-3,getdate())

select dateadd(dd,4,'03-sep-2008')

select datediff(dd,'03-sep-1980',getdate())

select datediff(mm,'03-sep-1980',getdate())

select datediff(ms,'03-sep-1980',getdate())

select month(getdate())

select year(getdate())

select abs(-12)

select floor(12.676)

select round(12.788,2)

select round(1234.567,2)

select round(1234.567,1)

select round(1234.567,0)

select round(1234.567,-1)

select round(1234.567,-2)

select round(1234.567,-3)

select round(1234.567,-4)

select sum(basic) from emptest

select avg(basic) from emptest

select count(basic) from emptest

select max(basic) from emptest

select min(basic) from emptest

select dept,sum(basic) from emptest group by dept

select dept,sum(basic) from emptest group by dept
having avg(basic) > 25999


select * from emptest order by dept 

select * from emptest order by dept
compute sum(basic)

select * from emptest order by dept
compute sum(basic) by dept

select * from emptest order by dept 
compute sum(basic) by dept
compute sum(basic)

select * from emp

drop table emp

create table emp
(
   empno int,nam varchar(15),dept varchar(15),
   desig varchar(15),basic int
)


sp_help emp

insert into emp values(1,'satish','asp','teamlead',39000)

insert into emp values(2,'narasimha','vb','developer',28484)

insert into emp values(3,'swapna','c#','manager',49999)

select * from emp

update emp set dept='xml',basic=39000 where
nam='narasimha'

delete from emp where empno=2

delete from emp where dept='c#'

select * from emp

truncate table emp

