use hexamarch;

drop table if exists Employ;

Create Table Employ
(
   Empno INT Primary Key,
   Name varchar(30) NOT NULL,
   Gender ENUM('MALE','FEMALE'),
   Dept varchar(30),
   Desig varchar(30),
   Basic Numeric(9,2)
);

Insert into Employ(Empno,Name,Gender,Dept,Desig,Basic) 
values(1,'Anushka','FEMALE','Java','Programmer',95234),
(2,'Manasvi','FEMALE','Sql','Dba',95344),
(3,'Jegan','MALE','Sql','Expert',96444),
(4,'Apoorv','MALE','Java','Programmer',95224),
(5,'Harshit','MALE','Sql','Expert',99344);

select * from Employ;