package com.silva.castro.hugo.vitor.dashboardtemplatejpa.baseEntity.dashboard

import com.silva.castro.hugo.vitor.dashboardtemplatejpa.sale.Sale
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface SalesByWeekServiceRep : org.springframework.data.repository.Repository<Sale, Long> {


    @Query(value = """
        select * from crosstab(${'$'}${'$'} select  slm.id,slm.name,extract (dow from saled_at) as day, sum(amount_sale) as value from 
                (select * from salesman s  where s.id in :salespeople) as slm,
                (select sales_man_id,saled_at,amount_sale from sale where sales_man_id  in :salespeople  and saled_at >= :startWeek and saled_at  <= :endWeek) as sl
                where slm.id = sl.sales_man_id
                group by slm.id,saled_at,slm.name order by slm.id,name,day
                ${'$'}${'$'},               'select m from generate_series(0,6) m'
                ) as ("id" int8,"name" text,"0"   float,"1"   float, "2"   float, "3"   float, "4" float, "5"   float, "6"   float)
    """, nativeQuery = true)
    fun getData(salesPeople: List<Long>, startWeek: LocalDate, endWeek: LocalDate): Any
}