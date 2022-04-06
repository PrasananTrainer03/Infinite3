-- 3
-- select last_day(curdate() ); gives last date of curent month.
select last_day(curdate() + interval 1 month);


-- 4
-- select adddate(curdate(), INTERVAL -1 month); gives last month of current date
-- select last_day(adddate(curdate(), INTERVAL -1 month)); gives last date of previous month.
select adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day);

select dayofweek(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day)) ;

select addDate(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day),
INTERVAL 6-dayofweek(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day)) DAY) 'First Friday', 
addDate(addDate(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day),
INTERVAL 6-dayofweek(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day)) DAY), INTERVAL 7 DAY)
'Second Friday',
addDate( addDate(addDate(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day),
INTERVAL 6-dayofweek(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day)) DAY), INTERVAL 7 DAY),INTERVAL 7 DAY) 
'Third Friday',
AddDate(addDate( addDate(addDate(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day),
INTERVAL 6-dayofweek(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day)) DAY), INTERVAL 7 DAY),INTERVAL 7 DAY) 
,INTERVAL 7 DAY)
'Fourth Friday', 
case when 
month(curdate()) = month(adddate(AddDate(addDate( addDate(addDate(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day),
INTERVAL 6-dayofweek(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day)) DAY), INTERVAL 7 DAY),INTERVAL 7 DAY) 
,INTERVAL 7 DAY)
,INTERVAL 7 DAY)) THEN 
adddate(AddDate(addDate( addDate(addDate(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day),
INTERVAL 6-dayofweek(adddate(last_day(adddate(curdate(), INTERVAL -1 month)), interval 1 day)) DAY), INTERVAL 7 DAY),INTERVAL 7 DAY) 
,INTERVAL 7 DAY) ,INTERVAL 7 DAY)
else '' END 'Fifth Friday'


