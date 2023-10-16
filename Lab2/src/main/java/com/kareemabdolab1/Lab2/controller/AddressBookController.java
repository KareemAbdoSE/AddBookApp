package com.kareemabdolab1.Lab2.controller;

import com.kareemabdolab1.Lab2.AddressBook;
import com.kareemabdolab1.Lab2.repository.AddressBookRepository;
import com.kareemabdolab1.Lab2.repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import com.kareemabdolab1.Lab2.*;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/addressBooks")
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    // Fetch all address books
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllAddressBooks() {
        return new ResponseEntity<>(addressBookRepository.findAll(), HttpStatus.OK);
    }

    // Fetch a single address book by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getAddressBookById(@PathVariable Long id) {
        AddressBook addressBook = addressBookRepository.findById(id).orElse(null);
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    // Create a new address book
    @PostMapping
    public ResponseEntity<AddressBook> createAddressBook(@RequestBody BuddyInfo buddyInfo) {
        AddressBook newAddressBook = new AddressBook();
        BuddyInfo newBuddy = buddyInfoRepository.save(buddyInfo);
        newAddressBook.addBuddy(newBuddy);
        AddressBook savedAddressBook = addressBookRepository.save(newAddressBook);
        return new ResponseEntity<>(savedAddressBook, HttpStatus.CREATED);
    }

    // Update an existing address book by ID
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateAddressBook(@PathVariable Long id, @RequestBody AddressBook addressBook) {
        AddressBook existingAddressBook = addressBookRepository.findById(id).orElse(null);
        if (existingAddressBook != null) {
            existingAddressBook.setBuddies(addressBook.getBuddies());
            addressBookRepository.save(existingAddressBook);
        }
        return new ResponseEntity<>(existingAddressBook, HttpStatus.OK);
    }

    // Delete an address book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddressBook(@PathVariable Long id) {
        addressBookRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}