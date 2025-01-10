package com.library.repository;

import com.library.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public List<Book> findAll(){
        return this.books;
    }

    public Optional<Book> findById(Long id){
        return this.books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    public String save(Book book){
        this.books.add(book);
        return "Book has been saved";
    }

    public String updateById(Long id, Book updatedBook) {
        return findById(id).map(book -> {
            books.remove(book);
            books.add(updatedBook);
            return "Book has been updated";
        }).orElse("Book not found");
    }

    public String deleteById(Long id){
        return findById(id).map(book -> {
            books.remove(book);
            return "Book has been deleted";
        }).orElse("Book not found");
    }

}
