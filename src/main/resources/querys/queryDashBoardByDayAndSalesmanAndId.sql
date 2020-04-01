select * from salesman s ;
CREATE EXTENSION tablefunc;


select * from sale;

/*
insert into salesman  values (1,now(),now(),'Mr Nobody');
insert into salesman  values (2,now(),now(),'Jordan Belfort');
insert into sale  values (1,now(),now(),5000,'2020-04-01',1);
insert into sale  values (2,now(),now(),5000,'2020-03-31',1);
insert into sale  values (4,now(),now(),2500,'2020-04-01',2);
*/
select * from salesman s  where s.id in (1,2);



select slm.name as row_name,extract (dow from saled_at) as day, sum(amount_sale) as value from (select * from salesman s  where s.id in (1,2)) as slm,
(select sales_man_id,saled_at,amount_sale from sale where sales_man_id  in (1,2)  and saled_at >= '2020-03-29' and saled_at  <= '2020-04-05') as sl
group by saled_at,slm.name order by name,day;


select * from crosstab('select slm.name,slm.id ,extract (dow from saled_at) as day, sum(amount_sale) as value from (select * from salesman s  where s.id in (1,2)) as slm,
(select sales_man_id,saled_at,amount_sale from sale where sales_man_id  in (1,2)  and saled_at >= ''2020-03-29'' and saled_at  <= ''2020-04-05'') as sl
group by saled_at,slm.name,slm.id order by name,id,day',
                'select m from generate_series(0,6) m'
                ) as ("name" text,"id" int8,
               "0"   float,
                "1"   float,
                "2"   float,
                "3"   float,
                "4"   float,
                "5"   float,
                "6"   float
                );
                
               
               
               
               
               
            