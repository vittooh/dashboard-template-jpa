package com.silva.castro.hugo.vitor.dashboardtemplatejpa.baseEntity.dashboard

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.SQLType
import java.sql.Types
import java.time.Instant
import java.time.LocalDate

@Repository
class SalesByWeekRepository {

    /* @Autowired
     lateinit var jdbc: JdbcTemplate
 */

    @Autowired
    lateinit var jdbc: NamedParameterJdbcTemplate

    //TODO create procedure Hibernate can deal with resultset and paginate  
    fun getByWeek(salesPeople: List<Long>, startWeek: LocalDate, endWeek: LocalDate) {
        val salesPeopleStr = salesPeople.joinToString(separator = ",", prefix = "(", postfix = ")")
        val query = """
            select slm.id, slm.name,extract (dow from saled_at) as day, sum(amount_sale) as value from 
            (select * from salesman s  where s.id in (:salesPeopleStr)) as slm,
            (select sales_man_id,saled_at,amount_sale from sale where sales_man_id  in (:salesPeopleStr)  and saled_at >= :startWeek and saled_at  <= :endWeek) as sl
            where slm.id = sl.sales_man_id
            group by slm.id,saled_at,slm.name order by slm.id,name,day
        """.trimIndent()


        val mapSqlParameterSource = MapSqlParameterSource()
        mapSqlParameterSource.addValue("salesPeopleStr", salesPeople,Types.ARRAY)
        mapSqlParameterSource.addValue("startWeek", startWeek,Types.DATE)
        mapSqlParameterSource.addValue("endWeek", endWeek,Types.DATE)

        val generateSerie = "select m from generate_series(0,6) m "

        val crosstab = "select * from crosstab ('$query','$generateSerie') as (\"id\" int8,\"name\" text,\"0\"   float,\"1\"   float, \"2\"   float, \"3\"   float, \"4\" float, \"5\"   float, \"6\"   float) "


        val list = jdbc.queryForList(crosstab, mapSqlParameterSource)


        println(list)
    }
}