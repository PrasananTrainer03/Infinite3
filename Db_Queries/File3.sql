-- Subqueries : 

-- Display Max Sal from Emp table

select max(sal) from Emp;

-- Display name of the person who is getting max. salary 

select ename from emp where sal=(select max(sal) from Emp);

-- Display the second max. salary 

select max(sal) from Emp where sal < (select max(sal) from Emp);

-- Display name employee who is getting second max. salary 

select ename from emp where sal =(select max(sal) from Emp where sal < (select max(sal) from Emp));

-- Display Idle agents (Which agentId exists in Agent Table, but not in AgentPolicy table) 

select * from Agent where AgentID <> ALL(select AgentId From AgentPolicy);

-- Dispay Idle Policies (Which PolicyID exists in Policy Table, but not in AgentPolicy Table) 

select * from policy WHERE PolicyID <> ALL(select PolicyID from agentpolicy);

-- Display Agents Exists in Both Agent and AgentPolicy Tables 

select * from Agent where AgentID=ANY(select AgentId from AgentPolicy);

-- Display Policy details, which exists in both Policy and AgentPolicy Tables 

select * from Policy where PolicyID=ANY(select PolicyID from AgentPolicy);


