package me.tony.practice.web.sec.service

import me.tony.practice.web.sec.jpa.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl : UserDetailsService {

    @Autowired
    lateinit var accountRepository: AccountRepository

    override fun loadUserByUsername(username: String): UserDetails {
        val acct = accountRepository.findAccountByLogin(username) ?: throw UsernameNotFoundException(username)
        return User(
            username,
            acct.password,
            if (username == "xiaozhu") listOf(SimpleGrantedAuthority("admin")) else emptyList()
        )
    }
}