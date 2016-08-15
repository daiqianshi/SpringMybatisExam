package com.service;

import com.dao.AddressDao;
import com.entitys.Address;

public class AddressService {
	
	private AddressDao addressDao;
	
	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
	
	public Address getAddressById(int id){
		return addressDao.getAddressById(id);
	}

}
