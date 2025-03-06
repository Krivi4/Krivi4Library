package ru.Krivi4Unity.library.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.Krivi4Unity.library.dao.BookDAO;
import ru.Krivi4Unity.library.models.Book;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookDAO bookDAO;

    public BooksController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

////////
//READ
///////

    @GetMapping()
    public String ShowAllBooks(Model model) {
        model.addAttribute("books", bookDAO.getAllBooks());
        return "books/showAll";
    }

    @GetMapping("/{id}")
    public String ShowBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.getBookById(id));
        return "books/show";
    }

/////////
//CREATE
/////////

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String AddBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "books/new";
        bookDAO.addBook(book);
        return "redirect:/books";
    }

/////////
//UPDATE
////////

    @GetMapping("/{id}/edit")
    public String editBook(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookDAO.getBookById(id));

        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String updateBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
                             @PathVariable ("id") int id) {
    if(bindingResult.hasErrors())
        return "books/edit";
    bookDAO.updateBook(id, book);
    return "redirect:/books";
    }

//////////
//DELETE
//////////

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookDAO.deleteBook(id);
        return "redirect:/books";
    }

}
