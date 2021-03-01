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
        return args -> {
            bookController.renderViewAllBooks();
            //edits the book
            bookController.renderMessageAfterBookNameUpdated("The Great Gatsby", 3L);
            //display all the books again
            bookController.renderViewAllBooks();
            //deletes a book
            bookController.renderMessageAfterDeletedBook(2L);
            //display all the books again
            bookController.renderViewAllBooks();
            //completed a form
            Book book = new Book("78989", "dhfghdfgh", true, 789);
            book.addPage(new Page("sdfsdf", 0));
            bookController.renderMessageAfterSavedBook(book);
            //display all the books again
            bookController.renderViewAllBooks();
            bookController.renderViewBookByISBNPage("4564565464567");
        };
    }


}
