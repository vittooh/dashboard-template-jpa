package com.silva.castro.hugo.vitor.dashboardtemplatejpa.baseEntity.dashboard

class AggregateByDay(
        var id: Long,
        var name: String,
        var mon: Double,
        var tue: Double,
        var wed: Double,
        var thu: Double,
        var fri: Double,
        var sat: Double,
        var sun: Double
)