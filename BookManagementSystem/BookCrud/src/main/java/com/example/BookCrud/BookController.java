package com.example.BookCrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

//import java.awt.print.Book;


@Controller
public class BookController {

    @Autowired
    private BookService service;

    //new book object
    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "new";
    }

    //GET all
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Book> listbook = service.listAll();
        model.addAttribute("listbook", listbook);
        System.out.print("Get / ");
        return "index";
    }

    //POST save new book
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
        service.save(book);
        return "redirect:/";
    }

//    PUT by id
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Book book = service.get(id);
        mav.addObject("book", book);
        return mav;
    }

//    DELETE by id
    @RequestMapping("/delete/{id}")
    public String deletebook(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }


}
