package com.tekwill.java.fundamentals.bookspringboot;

import com.tekwill.java.fundamentals.bookspringboot.controller.BookController;
import com.tekwill.java.fundamentals.bookspringboot.domain.Book;
import com.tekwill.java.fundamentals.bookspringboot.domain.Page;
import com.tekwill.java.fundamentals.bookspringboot.repo.BookRepositoryImpl;
import com.tekwill.java.fundamentals.bookspringboot.service.AuthorService;
import com.tekwill.java.fundamentals.bookspringboot.service.AuthorServiceImpl;
import com.tekwill.java.fundamentals.bookspringboot.service.BookServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BookSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookSpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthorService authorService, BookController bookController){
        //spring application context - we`ll have a bean named commandLineRunner with authorService and bookController dependencies automatically injected
        return args -> { };
    }


}
