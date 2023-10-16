package com.kareemabdolab1.Lab2.repository;

import com.kareemabdolab1.Lab2.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
    List<AddressBook> findByBuddies_Name(String name);
}