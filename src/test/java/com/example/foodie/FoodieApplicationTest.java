package com.example.foodie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration()
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("com.example.foodie")
@MapperScan("com.example.foodie.dao")
public class FoodieApplicationTest {
//    public static void main(String[] args) {
//        SpringApplicationBuilder builder = new SpringApplicationBuilder();
//        builder.environment(new StandardEnvironment());
//        builder.sources(FoodieApplicationTests.class);
//        builder.main(FoodieApplicationTests.class);
//        builder.run(args);
//    }
    public static void main(String[] args) {
        SpringApplication.run(FoodieApplicationTest.class, args);
    }
}