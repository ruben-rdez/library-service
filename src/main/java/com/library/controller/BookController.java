package com.library.controller;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Book book) {
        String message = bookService.save(book);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getPetById(@PathVariable Long id) {
        Optional<Book> book = bookService.findById(id);
        return book.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Book updatedBook) {
        String message = bookService. updateById(id, updatedBook);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        String message = bookService.deleteById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/welcome")
    public String greetings() {
        return "Welcome to Library Service";
    }

    @GetMapping("/login")
    public String login() {
        return "Logging to Library Service";
    }

    @GetMapping("/logout")
    public String logout() {
        return "Logging out from Library Service";
    }

}
