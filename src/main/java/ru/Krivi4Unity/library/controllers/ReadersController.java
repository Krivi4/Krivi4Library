package ru.Krivi4Unity.library.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.Krivi4Unity.library.dao.ReaderDAO;
import ru.Krivi4Unity.library.models.Reader;

import javax.validation.Valid;

@Controller
@RequestMapping("/readers")
public class ReadersController {

    private final ReaderDAO readerDAO;

    public ReadersController(ReaderDAO readerDAO) {
        this.readerDAO = readerDAO;
    }


////////
//READ
///////

    @GetMapping()
    public String ShowAllReader(Model model) {
        model.addAttribute("readers", readerDAO.getAllReaders());
        return "readers/showAll";
    }

    @GetMapping("/{id}")
    public String ShowReader(@PathVariable("id") int id, Model model) {
        model.addAttribute("reader", readerDAO.getReaderById(id));
        return "readers/show";
    }

/////////
//CREATE
/////////

    @GetMapping("/new")
    public String newReader(@ModelAttribute("reader") Reader reader) {
        return "readers/new";
    }

    @PostMapping()
    public String AddReader(@ModelAttribute("reader") @Valid Reader reader, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "readers/new";
        readerDAO.addReader(reader);
        return "redirect:/readers";
    }

/////////
//UPDATE
////////

    @GetMapping("/{id}/edit")
    public String editReader(Model model, @PathVariable("id") int id) {
        model.addAttribute("reader", readerDAO.getReaderById(id));

        return "readers/edit";
    }

    @PatchMapping("/{id}")
    public String updateReader(@ModelAttribute("reader") @Valid Reader reader, BindingResult bindingResult,
                             @PathVariable ("id") int id) {
        if(bindingResult.hasErrors())
            return "readers/edit";
        readerDAO.updateReader(id, reader);
        return "redirect:/readers";
    }

//////////
//DELETE
//////////

    @DeleteMapping("/{id}")
    public String deleteReader(@PathVariable("id") int id) {
        readerDAO.deleteReader(id);
        return "redirect:/readers";
    }

}
