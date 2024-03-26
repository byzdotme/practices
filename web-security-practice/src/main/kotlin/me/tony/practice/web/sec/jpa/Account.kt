package me.tony.practice.web.sec.jpa

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "account")
class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "login", unique = true, nullable = false, length = 64)
    var login: String? = null

    @Column(name = "password", nullable = false, length = 128)
    var password: String? = null

    @Column(name = "nickname", nullable = false, length = 256)
    var nickname: String? = null

    @Column(name = "avatar", nullable = false, length = 512)
    var avatar: String? = null

    @Column(name = "add_time", insertable = false, updatable = false)
    var addTime: OffsetDateTime? = null

    @Column(name = "update_time", insertable = false, updatable = false)
    var updateTime: OffsetDateTime? = null
}