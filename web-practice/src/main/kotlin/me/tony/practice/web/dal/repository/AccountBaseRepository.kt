package me.tony.practice.web.dal.repository

import me.tony.practice.web.dal.entity.AccountBase
import org.springframework.data.jpa.repository.JpaRepository

interface AccountBaseRepository : JpaRepository<AccountBase, Long>