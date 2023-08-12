package me.tony.practice.web.dal.entity

import org.hibernate.Hibernate
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.time.LocalDateTime
import jakarta.persistence.*

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "account_base")
class AccountBase {
    @Id
    @GeneratedValue(generator = "account_base_id_seq")
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "account_login", unique = true, length = 64, nullable = false)
    var login: String? = null

    @Column(name = "account_pwd", length = 128, nullable = false)
    var password: String? = null

    @Column(name = "account_state")
    var state: Int? = null

    @Column(name = "account_reg_time", insertable = false, updatable = false)
    var regTime: LocalDateTime? = null

    @Column(name = "add_time", insertable = false, updatable = false)
    var addTime: LocalDateTime? = null

    @Column(name = "update_time", insertable = false, updatable = false)
    var updateTime: LocalDateTime? = null

    @Column(name = "visible")
    var visible: Boolean? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as AccountBase

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , login = $login , password = $password , state = $state , regTime = $regTime )"
    }

}