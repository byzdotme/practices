package me.tony.practice.web.test

import me.tony.practice.web.AppMain
import me.tony.practice.web.dal.entity.AccountBase
import me.tony.practice.web.dal.repository.AccountBaseRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest(classes = [AppMain::class])
class JpaTest {

    @Autowired
    lateinit var accountBaseRepository: AccountBaseRepository


    @Test
    fun testFindById() {
        val findById = accountBaseRepository.findById(10)
        findById.ifPresentOrElse({ println(it) }) {
            println("none")
        }
    }

    @Test
    fun testInsert() {
        val entity = AccountBase()
        entity.login = "tonyaccount4"
        entity.password = "123456"
        accountBaseRepository.save(entity)
    }

    @Test
    fun testUpdate() {
//        val entity = AccountBase(id = 10, password = "111222333")
//        accountBaseRepository.save(entity)
//        accountBaseRepository.
    }
}