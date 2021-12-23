package com.consol.archunit.facade;

import com.consol.archunit.activity.BookBA;
import com.consol.archunit.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookBF {

    @Autowired
    private BookBA bookBA;

    public String modifyOrder(String order){

        return order + Math.random();
    }

    public Book getBookById(Long id) {
        return bookBA.getById(id);
    }

    public List<Book> getBooks() {
        return bookBA.getBooks();
    }

    public void saveBook(Book book) {
        bookBA.saveBook(book);
    }
}
