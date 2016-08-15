package com.service;

import com.dao.CustomerDao;
import com.entitys.Customer;

public class CustomerService {
	
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public Customer getCustomerById(int id){
		return customerDao.getCustomerById(id);
	}
	
	public void insertCustomer(Customer customer){
		customerDao.insertCustomer(customer);
	}
}
