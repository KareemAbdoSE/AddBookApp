package com.kareemabdolab1.Lab2.controller;

import com.kareemabdolab1.Lab2.AddressBook;
import com.kareemabdolab1.Lab2.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ViewController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/view/{id}")
    public String viewBuddies(@PathVariable Long id, Model model) {
        Optional<AddressBook> addressBook = addressBookRepository.findById(id);
        if (addressBook.isPresent()) {
            model.addAttribute("buddies", addressBook.get().getBuddies());
        }
        return "buddiesList";
    }
}