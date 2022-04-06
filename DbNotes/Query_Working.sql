-- Aggregate Functions 

-- SUM() : Perorms sum operation on the given Field 

select sum(sal) from Emp;

-- AVG() : Performs avg operation on the given field 

select avg(sal) from Emp;

-- Max() : Displays max. value 

select max(sal) from Emp;

-- Min() : Dispalays Min. value 

select min(sal) from Emp;

-- count(*) : Displays total no.of records 

select count(*) from Emp;

-- count(field_Name) : Displays total no.of records for which the field is not null 

select count(comm) from Emp;

select count(mgr) from Emp;

-- group by : Used to generate summary reports 

select job,sum(sal) from Emp 
group by job;

-- Display total no.of employees working in each dept(job) 

select job, count(*)
from Emp 
group by job;

-- Display max, min, avg, sum, count of employees working in each dept (job)

select job,sum(sal),avg(sal),max(sal),min(sal),count(*)
from Emp 
Group By JOb;

-- Having : Used to check condition on aggregate fields 

-- display all records for which job, we are paying more than 5000 sum(sal) 

select job, sum(sal)
from Emp 
group by job
having sum(sal) > 5000;

-- Display all dept(job) for which more than 1 employ working 

select job,count(*) 
from Emp 
Group by Job
having count(*) > 1;

