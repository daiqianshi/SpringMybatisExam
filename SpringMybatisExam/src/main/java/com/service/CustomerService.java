package com.service;

import com.dao.CustomerDao;
import com.entitys.Customer;
import com.event.MyPublish;

public class CustomerService {
	
	private CustomerDao customerDao;
	
	private MyPublish myPublish;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public Customer getCustomerById(int id){
		return customerDao.getCustomerById(id);
	}
	
	public MyPublish getMyPublish() {
		return myPublish;
	}

	public void setMyPublish(MyPublish myPublish) {
		this.myPublish = myPublish;
	}

	public void insertCustomer(Customer customer){
		myPublish.beforeInsertFilmEvent();
		customerDao.insertCustomer(customer);
		myPublish.afterInsertFilmEvent();
	}
}
