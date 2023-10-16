package com.kareemabdolab1.Lab2;

import com.kareemabdolab1.Lab2.repository.AddressBookRepository;
import com.kareemabdolab1.Lab2.repository.BuddyInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(AddressBookRepository repository, BuddyInfoRepository buddyInfoRepository) {
		return (args) -> {
			// Clearing old data
			repository.deleteAll();
			buddyInfoRepository.deleteAll();

			// Saving new data
			BuddyInfo buddy1 = new BuddyInfo("Kareem", "123-456-7890", "1233 colonel by drive");

			AddressBook addressBook = new AddressBook();
			addressBook.addBuddy(buddy1);

			repository.save(addressBook);

			// Fetch All AddressBooks
			System.out.println("AddressBooks found:");
			for (AddressBook book : repository.findAll()) {
				System.out.println(book);
			}

			// Fetch AddressBooks by Buddy's name
			System.out.println("BuddyInfo with name Kareem:");
			for (AddressBook book : repository.findByBuddies_Name("Kareem")) {
				for (BuddyInfo buddy : book.getBuddies()) {
					if ("Kareem".equals(buddy.getName())) {
						System.out.println(buddy);
					}
				}
			}

			// Fetch BuddyInfos by Phone number
			System.out.println("BuddyInfo with phone number 987-654-3210:");
			for (BuddyInfo buddy : buddyInfoRepository.findByPhoneNumber("987-654-3210")) {
				System.out.println(buddy);
			}
		};
	}
}