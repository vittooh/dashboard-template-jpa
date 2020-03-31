package com.silva.castro.hugo.vitor.dashboardtemplatejpa.sale

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "sale")
class Sale(
        var saledAt: Instant,
        var amountSale: Double
) {
}