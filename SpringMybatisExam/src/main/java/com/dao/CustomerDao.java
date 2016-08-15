package com.dao;

import com.entitys.Customer;

public interface CustomerDao {
	
	public Customer getCustomerById(int id);
	public void insertCustomer(Customer customer);
	
}
