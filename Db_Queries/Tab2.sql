use hexamarch;

drop table if exists LeaveDetails;

drop table if exists Employ;

Create Table Employ
(
   Empno INT AUTO_INCREMENT Primary Key,
   Name varchar(30) NOT NULL,
   Gender ENUM('MALE','FEMALE'),
   Dept varchar(30),
   Desig varchar(30),
   Basic Numeric(9,2)
);

Insert into Employ(Name,Gender,Dept,Desig,Basic) 
values('Anushka','FEMALE','Java','Programmer',95234),
('Manasvi','FEMALE','Sql','Dba',95344),
('Jegan','MALE','Sql','Expert',96444),
('Apoorv','MALE','Java','Programmer',95224),
('Harshit','MALE','Sql','Expert',99344);

select * from Employ;

drop table if exists LeaveDetails;

create Table LeaveDetails
(
 LeaveId INT AUTO_INCREMENT PRIMARY KEY,
 Empno INT REFERENCES Employ(Empno),
 LeaveTaken INT,
 LeaveAvail INT,
 Lop INT
);

Insert into LeaveDetails(Empno,LeaveTaken,LeaveAvail) values(1,2,2),(2,3,3),(2,2,0),(1,5,0),(3,3,5),(3,0,3);

select * from LeaveDetails;