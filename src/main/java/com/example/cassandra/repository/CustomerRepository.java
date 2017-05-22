package com.example.cassandra.repository;

import java.util.List;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cassandra.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

	@Query("select * from customer where firstname=?0 ALLOW FILTERING")
	public Customer findByFirstName(String firstName);

	@Query("select * from customer where lastname=?0 ALLOW FILTERING")
	public List<Customer> findByLastName(String lastName);

}