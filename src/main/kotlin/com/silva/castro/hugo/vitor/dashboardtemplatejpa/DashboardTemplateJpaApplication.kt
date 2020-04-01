package com.silva.castro.hugo.vitor.dashboardtemplatejpa

import com.silva.castro.hugo.vitor.dashboardtemplatejpa.baseEntity.dashboard.SalesByWeekRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.time.LocalDate


@SpringBootApplication
class DashboardTemplateJpaApplication : CommandLineRunner {

    @Autowired
    lateinit var salesByWeekRepository: SalesByWeekRepository

    override fun run(vararg args: String?) {
        salesByWeekRepository.getByWeek(
                mutableListOf(1, 2, 3),
                LocalDate.of(2020, 3, 29),
                LocalDate.of(2020, 4, 4)
        )
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(DashboardTemplateJpaApplication::class.java, *args)
}
