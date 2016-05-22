package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Book;
import com.springapp.mvc.repository.BookRepository;
import com.springapp.mvc.validation.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    private BookRepository bookRepository;
    private BookValidator bookValidator;

    @Autowired
    public BookController(BookRepository bookRepository, BookValidator bookValidator){
        this.bookRepository = bookRepository;
        this.bookValidator = bookValidator;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String getBooks(Model model) {
        List<Book> books = this.bookRepository.listAll();

        model.addAttribute("books", books);

        return "index";
    }

    @RequestMapping(value = "addBook", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @RequestMapping(value = "addBook", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String addBook(@ModelAttribute("book") Book book, BindingResult bindingResult){
        this.bookValidator.validate(book, bindingResult);

        if (bindingResult.hasErrors()){
            return "addBook";
        }

        this.bookRepository.addBook(book);
        return "redirect:/";
    }



    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String updateBook(@ModelAttribute("book") Book book, BindingResult bindingResult){
        this.bookValidator.validate(book, bindingResult);

        if (bindingResult.hasErrors()){
            return "/updateBook";
        }

        this.bookRepository.updateBook(book);
        return "redirect:/";
    }

    @RequestMapping(value = "deleteBook/{id}", method = RequestMethod.GET)
    //@PreAuthorize("hasRole('admin')")
    @PreAuthorize("isAuthenticated()")
    public String deleteBook(@PathVariable Integer id){
        this.bookRepository.removeBook(id);
        return "redirect:/";
    }

    @RequestMapping(value = "editBook/{id}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public ModelAndView editBook(@ModelAttribute("ubook") Book book, @PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateBook");
        book = this.bookRepository.getBook(id);
        modelAndView.addObject("editBook",book);
        return modelAndView;
    }





}
