Drop Database If Exists CmsMarch;

Create Database CmsMarch;

use CmsMarch;

Drop Table IF EXISTS RESTAURANT;
DROP TABLE IF EXISTS WALLET;
DROP TABLE IF EXISTS Menu;
drop table if exists vendor;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Orders;

Create Table Restaurant
(
   RestaurantID INT AUTO_INCREMENT Primary Key,
   RestaurantName varchar(30),
   RestaurantCity varchar(30),
   RestaurantState varchar(30),
   RestaurantEmail varchar(30),
   RestaurantMobile varchar(30)
);

Insert into Restaurant(RestaurantName,RestaurantCity,RestaurantState,RestaurantEmail,RestaurantMobile)
      values('Taj','Hyderabad','TS','tajhyd@gmail.com','99523555'),
      ('Chutneys','Hyderabad','TS','chutneys@gmail.com','94455333'),
      ('Paradise','Hyderabad','TS','paradise@gmail.com','95662234'),
      ('Sangeetha','Chennai','TN','sangeetha@gmail.com','99623444'),
      ('BBQ','Chennai','TN','BBQ@gmail.com','923868584'),
      ('Ohris','Bangalore','KA','Ohris@gmail.com','995833443'),
      ('A2B','Bangalore','KA','a2b@gmail.com','958835522'),
      ('Chillies','Bangalore','KA','chillies@gmail.com','959293445');

CREATE TABLE Menu (
  MEN_ID int(10)  NOT NULL AUTO_INCREMENT,
  RestaurantID INT REFERENCES Restaurant(RestaurantID),
  MEN_ITEM varchar(50) DEFAULT NULL,
  MEN_PRICE numeric(9,2),
  MEN_CALORIES double NOT NULL,
  MEN_SPECIALITY varchar(50) NOT NULL,
  PRIMARY KEY (MEN_ID)
);


insert into MENU set RestaurantID=1, MEN_ITEM='CHICKEN BIRIYANI', MEN_CALORIES=750 , MEN_SPECIALITY='NON-VEG', MEN_PRICE=856;
insert into MENU set RestaurantID=1, MEN_ITEM='CHICKEN 65', MEN_CALORIES=500 , MEN_SPECIALITY='NON-VEG',MEN_PRICE=674;
insert into MENU set RestaurantID=2, MEN_ITEM='GOBI MANCHURIAN', MEN_CALORIES=650 , MEN_SPECIALITY='VEG',MEN_PRICE=684;
insert into MENU set RestaurantID=2, MEN_ITEM='CHICKEN MANCHURIAN', MEN_CALORIES=750 , MEN_SPECIALITY='NON-VEG',MEN_PRICE=999;
insert into MENU set RestaurantID=3, MEN_ITEM='FISH', MEN_CALORIES=850 , MEN_SPECIALITY='NON-VEG',MEN_PRICE=901;
insert into MENU set RestaurantID=3, MEN_ITEM='DAHI BHALLE', MEN_CALORIES=150 , MEN_SPECIALITY='VEG',MEN_PRICE=111;
insert into MENU set RestaurantID=3,  MEN_ITEM='MIX PRANTHA', MEN_CALORIES=360 , MEN_SPECIALITY='VEG',MEN_PRICE=911;
insert into MENU set RestaurantID=4, MEN_ITEM='GOL GAPPE', MEN_CALORIES=170 , MEN_SPECIALITY='VEG',MEN_PRICE=901;
insert into MENU set RestaurantID=4, MEN_ITEM='PRAWN BIRYANI', MEN_CALORIES=580 , MEN_SPECIALITY='NON-VEG',MEN_PRICE=901;
insert into MENU set RestaurantID=5, MEN_ITEM='THAI NOODLES', MEN_CALORIES=660 , MEN_SPECIALITY='VEG',MEN_PRICE=744;

SELECT * FROM Menu;

SELECT M.MEN_ID,M.MEN_ITEM,M.MEN_PRICE,M.MEN_CALORIES,M.MEN_SPECIALITY
FROM MENU M;


-- Creating Customer table
 CREATE TABLE Customer (
  CUS_ID int(10) NOT NULL AUTO_INCREMENT,
  CUS_NAME varchar(50) NOT NULL,
  CUS_PHN_NO varchar(50) NOT NULL,
  CUS_USERNAME varchar(50) NOT NULL,
  CUS_PASSWORD varchar(50) NOT NULL,
  CUS_EMAIL varchar(50) NOT NULL,
  PRIMARY KEY (CUS_ID),
  UNIQUE KEY CUS_PHN_NO (CUS_PHN_NO),
  UNIQUE KEY CUS_USERNAME (CUS_USERNAME)
);

-- customer table 
INSERT INTO CUSTOMER(CUS_NAME,CUS_PHN_NO,CUS_USERNAME,CUS_PASSWORD,CUS_EMAIL) 
VALUES ('Prasanna Pappu','9381413089','prassucp','hexaware@', 'prassucp@gmail.com'),
       ('Krishna Kumar','8939391144','krishnak','chennai@123', 'krishnak@gmail.com'),
       ('Renu Srivastav','8755144556','Renu','ghazi@117', 'renusan@gmmail.com');

select C.CUS_ID,
	   C.CUS_NAME,C.CUS_PHN_NO,
       C.CUS_USERNAME,
       CUS_PASSWORD,
       CUS_EMAIL
FROM CUSTOMER C;

-- Creating Wallet table
 CREATE TABLE Wallet (
  CUS_ID int(10) unsigned DEFAULT NULL REFERENCES CUSTOMER(CUS_ID),
  WAL_ID int(10) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  WAL_AMOUNT double unsigned NOT NULL,
  WAL_SOURCE enum('PAYTM','CREDIT_CARD','DEBIT_CARD') DEFAULT 'DEBIT_CARD',
  UNIQUE KEY(CUS_ID,WAL_SOURCE)
);

-- wallet table
INSERT INTO WALLET(CUS_ID,WAL_AMOUNT,WAL_SOURCE) 
VALUES (1,2000.00,'PAYTM'),
       (1,3000.00,'DEBIT_CARD'),
       (1,5602.36,'CREDIT_CARD'),
       (2,4500.36,'DEBIT_CARD'),
       (3,485.23,'CREDIT_CARD'),
       (2,3000,'CREDIT_CARD'),
       (2,4560,'PAYTM'),
       (3,56.36,'PAYTM'),
       (3,4566,'DEBIT_CARD');


SELECT * FROM WALLET;


-- creating vendor table
 CREATE TABLE vendor (
  VEN_ID int(10) unsigned NOT NULL AUTO_INCREMENT,
  VEN_NAME varchar(50) NOT NULL,
  VEN_PHN_NO varchar(40) NOT NULL,
  VEN_USERNAME varchar(40) NOT NULL,
  VEN_PASSWORD varchar(30) NOT NULL,
  VEN_EMAIL varchar(50) NOT NULL,
  PRIMARY KEY (`VEN_ID`)
) ;

-- vendor table
INSERT INTO VENDOR(VEN_ID,VEN_NAME,VEN_PHN_NO,VEN_USERNAME,VEN_PASSWORD,VEN_EMAIL) VALUES(1,'Balan',8554535400,'balan89','chennai@123','balan@gmail.com');
INSERT INTO VENDOR(VEN_ID,VEN_NAME,VEN_PHN_NO,VEN_USERNAME,VEN_PASSWORD,VEN_EMAIL) VALUES(2,'Anukriti',9184532455,'anu56','bordia@123','anu.delhi@gmail.com');
INSERT INTO VENDOR(VEN_ID,VEN_NAME,VEN_PHN_NO,VEN_USERNAME,VEN_PASSWORD,VEN_EMAIL) VALUES(3,'Aarifa',9115879011,'aarifk','saleem@123','aarifkhan@gmail.com');
INSERT INTO VENDOR(VEN_ID,VEN_NAME,VEN_PHN_NO,VEN_USERNAME,VEN_PASSWORD,VEN_EMAIL) VALUES(4,'Ksheerabdi',9874499011,'ksheera','kolkata@123','ramki9@gmail.com');


select * from Vendor;

-- Creating orders table
CREATE TABLE orders (
  ORD_ID int(10) NOT NULL AUTO_INCREMENT,
  CUS_ID int(10) unsigned NOT NULL REFERENCES customer (CUS_ID),
  VEN_ID int(10) unsigned NOT NULL REFERENCES VENDOR (VEN_ID),
  WAL_SOURCE Varchar(30),
  MEN_ID INT(10) NOT NULL REFERENCES MENU(MEN_ID),
  ORD_DATE date,
  ORD_QUANTITY INT,
  ORD_BILLAMOUNT double,
  ORD_STATUS enum('ACCEPTED','DENIED','PENDING') DEFAULT 'PENDING',
  ORD_COMMENTS varchar(50) DEFAULT NULL,
  PRIMARY KEY (ORD_ID)
);

