package com.consol.archunit.activity;

import com.consol.archunit.entity.Book;
import com.consol.archunit.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookBA {

    @Autowired
    private BookRepository bookRepository;

    public Book getById(Long id) {
        return bookRepository.getById(id);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }
}
