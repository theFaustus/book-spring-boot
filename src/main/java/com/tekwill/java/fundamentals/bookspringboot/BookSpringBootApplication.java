package com.tekwill.java.fundamentals.bookspringboot;

import com.tekwill.java.fundamentals.bookspringboot.controller.BookRestController;
import com.tekwill.java.fundamentals.bookspringboot.service.AuthorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookSpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthorService authorService, BookRestController bookRestController){
        //spring application context - we`ll have a bean named commandLineRunner with authorService and bookController dependencies automatically injected
        return args -> { };
    }


}
