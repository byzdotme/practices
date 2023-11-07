//package me.tony.practice.web.app.conf
//
//import jakarta.persistence.EntityManager
//import org.springframework.boot.context.properties.ConfigurationProperties
//import org.springframework.boot.jdbc.DataSourceBuilder
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.context.annotation.Primary
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories
//import javax.sql.DataSource
//
//@Configuration
//class DataSourceConfig {
//
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.first")
//    fun firstDatasource(): DataSource = DataSourceBuilder.create().build()
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.second")
//    fun secondDatasource(): DataSource = DataSourceBuilder.create().build()
//}
//
//@Configuration
//@EnableJpaRepositories
//class FirstDataSourceConfig {
//
//    @Bean
//    fun firstEntityManager(builder: EntityManagerFactoryBuilder):EntityManager {
//        builder.dataSource()
//    }
//
//}