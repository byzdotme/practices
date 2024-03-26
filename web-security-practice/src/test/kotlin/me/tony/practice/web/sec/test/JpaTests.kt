package me.tony.practice.web.sec.test

import me.tony.practice.web.sec.App
import me.tony.practice.web.sec.jpa.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ContextConfiguration
import kotlin.test.Test
import kotlin.test.assertNotNull


@DataJpaTest
@ContextConfiguration(classes = [App::class])
class JpaTests {

    @Autowired
    lateinit var accountRepository: AccountRepository

    @Test
    fun test() {
        val findAccountByLogin = accountRepository.findAccountByLogin("xiaozhu")
        assertNotNull(findAccountByLogin)
    }
}