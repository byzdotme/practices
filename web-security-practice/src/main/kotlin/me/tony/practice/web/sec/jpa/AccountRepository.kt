package me.tony.practice.web.sec.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface AccountRepository : JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {

    fun findAccountByLogin(login: String): Account?
}