desc Dept;

desc emp;

-- In above table, Dept table Deptno is primary key, where in Emp table DeptNo is Foreign Key 

-- Now, till time we are extracting data by using single sql statement, now on we have to extract data from more than one table

-- then we need the help of joins 

select Dept.DeptNo,Dname,Empno,Ename,job,Sal
from Dept INNER JOIN Emp 
ON Dept.Deptno=Emp.Deptno;

select D.Deptno,Dname,Loc,E.Empno,Ename,Job,Sal
from Dept D INNER JOIN Emp E 
ON D.Deptno=E.Deptno ;

select A.AgentId,FirstName,LastName,City,State,
P.PolicyID,ModalPremium,AnnualPremium
from Agent A INNER JOIN AgentPolicy AP
ON A.AgentID=Ap.AgentID INNER JOIN Policy P 
ON P.PolicyID = AP.PolicyID;


-- LEFT OUTER JOIN 

select Dept.DeptNo,Dname,Empno,Ename,job,Sal
from Dept LEFT JOIN Emp 
ON Dept.Deptno=Emp.Deptno;

select A.AgentId,FirstName,LastName,City,State,
P.PolicyID,ModalPremium,AnnualPremium
from Agent A LEFT JOIN AgentPolicy AP
ON A.AgentID=Ap.AgentID LEFT JOIN Policy P 
ON P.PolicyID = AP.PolicyID;


-- Right Outer Join

select A.AgentId,FirstName,LastName,City,State,
P.PolicyID,ModalPremium,AnnualPremium
from Agent A RIGHT JOIN AgentPolicy AP
ON A.AgentID=Ap.AgentID RIGHT JOIN Policy P 
ON P.PolicyID = AP.PolicyID;




