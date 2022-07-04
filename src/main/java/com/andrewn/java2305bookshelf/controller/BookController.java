package com.andrewn.java2305bookshelf.controller;

import com.andrewn.java2305bookshelf.DTO.BookForm;
import com.andrewn.java2305bookshelf.domain.Book;
import com.andrewn.java2305bookshelf.exception.BookNotFoundException;
import com.andrewn.java2305bookshelf.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;

@Controller
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/index")
    String bookshelf(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @DeleteMapping("/index")
    String bookshelfFromDelete(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @GetMapping("/book/{id}")
    String bookInfo(Model model, @PathVariable("id") Long id) {
        return bookRepository.findById(id)
                .map((book) -> {
                    model.addAttribute("book", book);
                    return "book-info";
                })
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @DeleteMapping("/book/{id}")
    String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/add-new-book")
    String addBookForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "add-new-book";
    }

    @PostMapping("/add-new-book")
    RedirectView saveNewBook(@ModelAttribute BookForm bookForm) {
        Book newBook = new Book(bookForm.getTitle(), bookForm.getAuthor(), new Date());
        newBook = bookRepository.saveAndFlush(newBook);
        return new RedirectView("/book/" + newBook.getId());
    }
}
