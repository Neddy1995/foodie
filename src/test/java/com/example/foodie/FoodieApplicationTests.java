package com.example.foodie;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class FoodieApplicationTests {
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.environment(new StandardEnvironment());
        builder.sources(FoodieApplicationTests.class);
        builder.main(FoodieApplicationTests.class);
        builder.run(args);
    }
}