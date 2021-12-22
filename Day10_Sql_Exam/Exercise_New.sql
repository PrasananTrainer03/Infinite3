Create Table EmployInfinite
(
    Empno int AUTO_INCREMENT,
    Name varchar(50), 
    Dept varchar(30),
    Desig varchar(30),
    Basic INT,
    primary key(Empno)
);


Insert into EmployInfinite(Name,Dept,Desig,Basic) values
('kiran kumar kailasam','java','developer',42233),
('Vishnu Vardhan Reddy','dotnet','programmer',42133),
('Ram Kishan','java','developer',82233),
('Kareem','dotnet','programmer',52234),
('Sheik Sulthan Mohammad','dotnet','developer',42555);


Select * from EmployInfinite;
/* Create above table and write the below queries

8) Display all details of Employ table who have 1 part name (as only 1 word) ex(only one word kareen)

9) Display all details of Employ tabble who have 2 part name (ex 2 words) (ram kishan)

10) Display all details of Employ table who have 3 part name (ex : Sheik Sulthan Mohammad etcc) */
