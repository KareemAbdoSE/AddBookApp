package com.kareemabdolab1.Lab2;

import com.kareemabdolab1.Lab2.repository.*;
import com.kareemabdolab1.Lab2.AddressBook;
import com.kareemabdolab1.Lab2.BuddyInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class JPATestWithSpring {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private BuddyInfoRepository buddyInfoRepository;

	@Autowired
	private AddressBookRepository addressBookRepository;

	@Test
	public void insertAndPrintData() {
		// Create BuddyInfo objects
		BuddyInfo buddy1 = new BuddyInfo("Kareem", "123-456-7890");
		BuddyInfo buddy2 = new BuddyInfo("Abdo", "987-654-3210");
		BuddyInfo buddy3 = new BuddyInfo("Alex", "555-123-4444"); // another dummy buddy

		// Create an AddressBook and add buddies to it
		AddressBook addressBook1 = new AddressBook();
		AddressBook addressBook2 = new AddressBook();
		addressBook1.addBuddy(buddy1);
		addressBook1.addBuddy(buddy2);
		addressBook2.addBuddy(buddy3);

		// Persist the AddressBooks
		addressBookRepository.save(addressBook1);
		addressBookRepository.save(addressBook2);
	}
}
