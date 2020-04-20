
select * from crosstab($$ select  slm.id,slm.name,to_char(saled_at ,'DAY')  as day, sum(amount_sale) as value from 
(select * from salesman s  where s.id in :salespeople) as slm,
(select sales_man_id,saled_at,amount_sale from sale where sales_man_id  in :salespeople  and saled_at >= :startWeek and saled_at  <= :endWeek) as sl
where slm.id = sl.sales_man_id
group by slm.id,saled_at,slm.name order by slm.id,name,day
$$,               $$select to_char(day_of_week,'DAY') as day from generate_series(:startWeek::date,:endWeek::date,'1 day') as m(day_of_week)
 $$
                ) as ("id" int8,"name" text,"MONDAY"   float,"SUNDAY"   float, "TUESDAY"   float, "WEDNESDAY"
               float, "THURSDAY" float, "FRIDAY"   float, "SATURDAY"   float);
 


              

drop type teste4;
create type teste4 as (
"id" int8,"name" text,"MONDAY"   float,"SUNDAY"   float, "TUESDAY"   float, "WEDNESDAY"
               float, "THURSDAY" float, "FRIDAY"   float, "SATURDAY"   float
)

--select * from crosstab($$select  slm.id,slm.name,to_char(saled_at ,'DAY')  as day, sum(amount_sale) as value from 
--(select * from salesman s  where s.id = any(salespeople)) as slm,
--(select sales_man_id,saled_at,amount_sale from sale where sales_man_id  in  any(salespeople)  and saled_at >= startWeek and saled_at  <= endWeek) as sl
--where slm.id = sl.sales_man_id group by slm.id,saled_at,slm.name order by slm.id,name,day $$,
--$$select to_char(day_of_week,'DAY') as day from generate_series(startWeek::date,endWeek::date,'1 day') as m(day_of_week) 
--                ) as ("id" int8,"name" text,"MONDAY"   float,"SUNDAY"   float, "TUESDAY"   float, "WEDNESDAY"
--               float, "THURSDAY" float, "FRIDAY"   float, "SATURDAY"   float)$$
       

drop function buildData;
create or replace function buildData(salespeople integer[],startWeek date, endWeek date) returns varchar
as  $PROC$
select * from format()
 $PROC$ language sql;
select format('select * from salesman where id = any(%s)',array_to_string(array[1,2,3],','))


select to_char(day_of_week,'DAY') as day,extract(dow from day_of_week) as dow
from generate_series('2020-04-20'::date,'2020-05-01'::date,'1 day') as m(day_of_week)





select extract (dow from now())






CREATE FUNCTION dup(int) RETURNS TABLE(f1 int, f2 text)
    AS $$ SELECT $1, CAST($1 AS text) || ' is text' $$
    LANGUAGE SQL;

SELECT * FROM dup(42);




