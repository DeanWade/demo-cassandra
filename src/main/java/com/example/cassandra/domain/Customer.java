package com.example.cassandra.domain;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.utils.UUIDs;

@Table
public class Customer implements Serializable {
	
	private static final long serialVersionUID = -5459922677269164819L;

	@PrimaryKey
	private UUID id;

	@Column("firstname")
	private String firstName;

	@Column("lastname")
	private String lastName;

	public Customer() {
	}
	
	public Customer(String firstName, String lastName) {
		this.id = UUIDs.timeBased();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer(UUID id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s']", this.id,
				this.firstName, this.lastName);
	}

}
