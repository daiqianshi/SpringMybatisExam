package com.hand;

import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entitys.Address;
import com.entitys.Customer;
import com.service.AddressService;
import com.service.CustomerService;

public class App 
{
    public static void main( String[] args )
    {
    	int address_id = 0;
    	String first_name = null;
    	String last_name = null;
    	String email = null;
    	Date create_date = new Date();
    	boolean addressExist = false;
    	BeanFactory factory = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
    	CustomerService customerService = factory.getBean("customerService", CustomerService.class);
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.print("first_name：");
    	first_name = scanner.nextLine();
    	System.out.print("last_name：");
    	last_name = scanner.nextLine();
    	System.out.print("email：");
    	email = scanner.nextLine();
    	System.out.print("address_id：");
    	address_id = scanner.nextInt();
    	
    	AddressService addressService = factory.getBean("addressService", AddressService.class);
    	Address address = addressService.getAddressById(address_id);
    		//address_id = scanner.nextInt();
    	  Customer customer = new Customer();
    		if (address.getAddress() == null || "".equals(address.getAddress())) {
    			System.out.print("无效的地址输入，请再次输入:");
    			address_id = scanner.nextInt();
    			address = addressService.getAddressById(address_id);
    		}else {
				System.out.println("ssssssss1");
			    customer.setStore_id(1);
			    customer.setFirst_name(first_name);
			    customer.setLast_name(last_name);
			    customer.setEmail(email);
			    customer.setAddress_id(address_id);
			    customer.setCreate_date(create_date);
			    
				customerService.insertCustomer(customer);
				System.out.println(customer.getCustomer_id());
				
				Customer customer1 = customerService.getCustomerById(customer.getCustomer_id());
	        	System.out.println("first_name:" + customer1.getFirst_name());
	        	System.out.println("last_name:" + customer1.getLast_name());
	        	System.out.println("email:" + customer1.getEmail());
	        	System.out.println("create_date:" + customer1.getCreate_date());
			}
    		
    		/*Customer customer1 = customerService.getCustomerById(1);
        	System.out.println("first_name" + customer1.getFirst_name());*/
    }
}
