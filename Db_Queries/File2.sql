-- Cross Join

select * from Dept cross Join Emp;

-- Self Join :  If a table joins with itself known as Self Join, here we need to take 2 aliases for comparing the data 

select Empno,Ename,job,sal,mgr
from Emp;

select E1.Empno 'Manager Id', E1.EName 'Manager Name',
E2.Empno 'Employ No', E2.EName 'Employ Name'
from Emp E1 INNER JOIN Emp E2 
ON E1.Empno= E2.Mgr
Order By E1.Empno;

