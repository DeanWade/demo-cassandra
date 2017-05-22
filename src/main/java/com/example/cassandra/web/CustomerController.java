package com.example.cassandra.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cassandra.domain.Customer;
import com.example.cassandra.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("/rest")
	public Customer rest(){
		Customer customer = new Customer("firstname", "lastname");
		return customer;
	}
	
	@GetMapping("/save")
	public Customer save(){
		Customer customer = new Customer("firstname", "lastname");
		return customerRepository.save(customer);
	}
	
	@GetMapping("/deleteAll")
	public String deleteAll(){
		customerRepository.deleteAll();
		return "deleted!";
	}
	
	@GetMapping("/findAll")
	public Object findAll(){
		return customerRepository.findAll();
	}
	
	@GetMapping(path="/findByFirstName", produces = "application/json; charset=UTF-8")
	public Customer findByFirstName(@Param("firstname") String firstname){
		return customerRepository.findByFirstName(firstname);
	}
}
