package me.tony.practice.web.sec

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.SecurityFilterChain

@SpringBootApplication
@EnableWebSecurity
class App {
    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web ->
            web.ignoring().requestMatchers("/api/noauth")
        }
    }

    @Bean
    fun securityFilterChain(httpSecurity: HttpSecurity, userDetailsService: UserDetailsService): SecurityFilterChain {
        return httpSecurity.userDetailsService(userDetailsService)
            .authorizeHttpRequests { cus ->
                cus.requestMatchers("/api/noauth").permitAll()
                    .requestMatchers("/api/admin").hasRole("admin")
                    .anyRequest().authenticated()
            }.build()
    }

}

fun main(args: Array<String>) {
    runApplication<App>(*args)
}