package me.tony.practice.web.dal.entity

import jakarta.persistence.*
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

@Entity
@Table(name = "t_user")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Size(max = 32)
    @Column(name = "login", nullable = false, length = 32)
    open lateinit var login: String

    @Size(max = 256)
    @Column(name = "avatar", length = 256)
    open var avatar: String? = null

    @Column(name = "status", nullable = false)
    open var status: Int = 1

    @Column(name = "add_time", insertable = false, updatable = false)
    open var addTime: LocalDateTime? = null

    @Column(name = "update_time", insertable = false, updatable = false)
    open var updateTime: LocalDateTime? = null


    override fun toString(): String {
        return "User(id=$id, login='$login', avatar=$avatar, status=$status, addTime=$addTime, updateTime=$updateTime)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (id != other.id) return false
        if (login != other.login) return false
        if (avatar != other.avatar) return false
        if (status != other.status) return false
        if (addTime != other.addTime) return false
        if (updateTime != other.updateTime) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + login.hashCode()
        result = 31 * result + (avatar?.hashCode() ?: 0)
        result = 31 * result + status
        result = 31 * result + addTime.hashCode()
        result = 31 * result + updateTime.hashCode()
        return result
    }


}