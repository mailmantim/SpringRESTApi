package com.example.BookCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    // get all
    public List<Book> listAll() {
        return repo.findAll();
    }


    //post new book
    public void save(Book book) {
        repo.save(book);
    }


    //get by id
    public Book get(long id) {
        return repo.findById(id).get();
    }


    //delete by id
    public void delete(long id) {
        repo.deleteById(id);
    }


    // delete all
    public void deleteAllItem() {
        repo.deleteAll();
    }

    // update for REST
    public void updateById(Book book, long id) {
        repo.save(book);
    }

    // get all for REST
    public Optional<Book> getById(long id) {
        Optional<Book> userRecord = repo.findById(id);
        return userRecord;
    }

}