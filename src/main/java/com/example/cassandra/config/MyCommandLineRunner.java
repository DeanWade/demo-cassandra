package com.example.cassandra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.datastax.driver.core.utils.UUIDs;
import com.example.cassandra.domain.Customer;
import com.example.cassandra.repository.CustomerRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Override
	public void run(String... args) throws Exception {
//		this.repository.deleteAll();

		// save a couple of customers
		this.repository.save(new Customer("Alice", "Smith"));
		this.repository.save(new Customer("Bob", "Smith"));
		// fetch all customers
		System.out.println("Customers found with findAll():");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : this.repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}
}
