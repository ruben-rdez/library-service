package com.library.service;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    public String save(Book book) {
        return this.bookRepository.save(book);
    }

    public String updateById(Long id, Book book){
        return this.bookRepository.updateById(id, book);
    }

    public String deleteById(Long id) {
        return this.bookRepository.deleteById(id);
    }
}
