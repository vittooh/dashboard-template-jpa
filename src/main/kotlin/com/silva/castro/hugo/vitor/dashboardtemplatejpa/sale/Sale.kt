package com.silva.castro.hugo.vitor.dashboardtemplatejpa.sale

import com.silva.castro.hugo.vitor.dashboardtemplatejpa.baseEntity.BaseEntity
import com.silva.castro.hugo.vitor.dashboardtemplatejpa.salesman.SalesMan
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "sale")
class Sale(
        var saledAt: Instant,
        var amountSale: Double
): BaseEntity()  {

    @ManyToOne
    var salesMan : SalesMan? = null
}