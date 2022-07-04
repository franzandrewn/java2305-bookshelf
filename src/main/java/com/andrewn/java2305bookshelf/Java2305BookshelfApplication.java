package com.andrewn.java2305bookshelf;

import com.andrewn.java2305bookshelf.domain.Book;
import com.andrewn.java2305bookshelf.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Java2305BookshelfApplication {

	private static final Logger logger = LoggerFactory.getLogger(Java2305BookshelfApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Java2305BookshelfApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(BookRepository bookRepository) {
		return (args) -> {
			logger.info(String.valueOf(bookRepository.save(new Book("Song of Ice and Fire","J.R.R.Martin"))));
			logger.info(String.valueOf(bookRepository.save(new Book("Hobbit","Tolkien", new Date()))));
		};
	}
}
