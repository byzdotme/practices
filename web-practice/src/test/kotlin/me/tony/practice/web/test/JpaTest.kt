package me.tony.practice.web.test

import me.tony.practice.web.AppMain
import me.tony.practice.web.dal.entity.AccountBase
import me.tony.practice.web.dal.entity.User
import me.tony.practice.web.dal.repository.AccountBaseRepository
import me.tony.practice.web.dal.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.Ignore


@SpringBootTest(classes = [AppMain::class])
@Ignore
class JpaTest {

    @Autowired
    lateinit var repository: UserRepository


    @Test
    fun testFindById() {
        val findById = repository.findById(10)
        findById.ifPresentOrElse({ println(it) }) {
            println("none")
        }
    }

    @Test
    fun testInsert() {
        val entity = User()
        entity.login = "bootz4"
        repository.save(entity)
        println(entity)
    }

    @Test
    fun testUpdate() {
        val findById = repository.findById(10)
        findById.ifPresent {
            println("before: $it")
            it.avatar = "new.png"
            repository.save(it)
            println("after: $it")
        }
        val opt = repository.findById(10)
        opt.ifPresent {
            println("new: $it")
        }
    }
}