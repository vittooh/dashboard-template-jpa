package com.silva.castro.hugo.vitor.dashboardtemplatejpa.salesman

import com.silva.castro.hugo.vitor.dashboardtemplatejpa.baseEntity.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "salesman")
class SalesMan(
        var name: String
) : BaseEntity()