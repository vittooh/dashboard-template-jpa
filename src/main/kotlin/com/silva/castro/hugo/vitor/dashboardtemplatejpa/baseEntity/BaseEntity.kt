package com.silva.castro.hugo.vitor.dashboardtemplatejpa.baseEntity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import javax.persistence.*

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @CreatedDate
    var createDate: Instant? = null

    @LastModifiedDate
    var updateAt: Instant? = null
}