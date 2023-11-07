package me.tony.practice.web.dal.repository

import me.tony.practice.web.dal.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>