package com.kareemabdolab1.Lab2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore  // This will prevent 'id' from showing up in the JSON
    private Long id;

    private String address;
    private String name;
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressBook_id")
    @JsonIgnore
    private AddressBook addressBook;

    public BuddyInfo() {
    }

    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public BuddyInfo(String name, String phoneNumber , String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    @Override
    public String toString() {
        return "BuddyInfo{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}