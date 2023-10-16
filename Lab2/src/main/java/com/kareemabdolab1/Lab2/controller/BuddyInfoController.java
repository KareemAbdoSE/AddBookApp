package com.kareemabdolab1.Lab2.controller;

import com.kareemabdolab1.Lab2.BuddyInfo;
import com.kareemabdolab1.Lab2.repository.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buddies")
public class BuddyInfoController {

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    // Fetch all buddies
    @GetMapping
    public ResponseEntity<List<BuddyInfo>> getAllBuddies() {
        return new ResponseEntity<>(buddyInfoRepository.findAll(), HttpStatus.OK);
    }

    // Fetch a single buddy by ID
    @GetMapping("/{id}")
    public ResponseEntity<BuddyInfo> getBuddyById(@PathVariable Long id) {
        BuddyInfo buddyInfo = buddyInfoRepository.findById(id).orElse(null);
        return new ResponseEntity<>(buddyInfo, HttpStatus.OK);
    }

    // Create a new buddy
    @PostMapping
    public ResponseEntity<BuddyInfo> createBuddy(@RequestBody BuddyInfo buddyInfo) {
        BuddyInfo newBuddy = buddyInfoRepository.save(buddyInfo);
        return new ResponseEntity<>(newBuddy, HttpStatus.CREATED);
    }

    // Update an existing buddy by ID
    @PutMapping("/{id}")
    public ResponseEntity<BuddyInfo> updateBuddy(@PathVariable Long id, @RequestBody BuddyInfo buddyInfo) {
        BuddyInfo existingBuddy = buddyInfoRepository.findById(id).orElse(null);
        if (existingBuddy != null) {
            existingBuddy.setName(buddyInfo.getName());
            existingBuddy.setPhoneNumber(buddyInfo.getPhoneNumber());
            buddyInfoRepository.save(existingBuddy);
        }
        return new ResponseEntity<>(existingBuddy, HttpStatus.OK);
    }

    // Delete a buddy by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuddy(@PathVariable Long id) {
        buddyInfoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}