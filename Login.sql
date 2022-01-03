SELECT * FROM infinitepractice.employ;

create table users
(
   userName varchar(30) primary key,
   passCode varchar(30)
);

insert into Users(userName,passcode) values('Shahida','Sheik'),('Mohammad','Thaga'),('Omkar','Bhagat'),('Swathi','Tonne');

select count(*) cnt from Users where userName='Shahida' and Passcode='Shefffik';
select * from Users;