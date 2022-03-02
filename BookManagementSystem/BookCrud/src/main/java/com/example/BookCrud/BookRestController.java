package com.example.BookCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

//import java.awt.print.Book;


@RestController
public class BookRestController {

    @Autowired
    private BookService service;

    // GET by id
    @RequestMapping(value="/admin/{id}", method=RequestMethod.GET)
    public Optional<Book> getBookById(@PathVariable long id)
    {
        return service.getById(id);
    }

    // GET all
    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public List<Book> getAllItem()
    {
        return service.listAll();
    }

    // POST create new book
    @RequestMapping(value="/admin", method=RequestMethod.POST)
    public void addItem(@RequestBody Book book)
    {
        service.save(book);
    }

    // PUT update book
    @RequestMapping(value="/admin/{id}", method=RequestMethod.PUT)
    public void updateById(@RequestBody Book book, @PathVariable long id)
    {
        service.updateById(book,id);
    }

    // DELETE all
    @RequestMapping(value = "/admin/deleteall", method = RequestMethod.DELETE)
    public void DeleteBook(@ModelAttribute("book") Book book) {
        service.deleteAllItem();
    }

    // DELETE by id
    @RequestMapping(value = "/admin/{id}", method = RequestMethod.DELETE)
    public void DeleteBookById(@ModelAttribute("book") Book book, @PathVariable long id) {
        service.delete(id);
    }

}
