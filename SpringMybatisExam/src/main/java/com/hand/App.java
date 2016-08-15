package com.hand;

import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

import com.entitys.Address;
import com.entitys.Customer;
import com.service.AddressService;
import com.service.CustomerService;

public class App 
{
    public static void main( String[] args )
    {
    	BeanFactory factory = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
    	
    	int address_id = 0;
    	String first_name = null;
    	String last_name = null;
    	String email = null;
    	Date create_date = new Date();
    	boolean addressExist = false;
    	
    	//数据输入
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("请输入你的信息：");
    	System.out.print("first_name：");
    	first_name = scanner.nextLine();
    	System.out.print("last_name：");
    	last_name = scanner.nextLine();
    	System.out.print("email：");
    	email = scanner.nextLine();
    	System.out.print("address_id：");
    	//address_id = scanner.nextInt();
    	do {
    		address_id = scanner.nextInt();
    		if (!addressExist(factory, address_id)) {
    			System.out.println("无效输入，请重新输入：");
			}else {
				System.out.println("有效输入");
				addressExist = true;
				break;
			}
		} while (!addressExist);
    		//address_id = scanner.nextInt();
    	//执行插入和显示操作
    	if (addressExist) {
    		Customer customer = new Customer();    		
			System.out.println("ssssssss");
			customer.setStore_id(1);
			customer.setFirst_name(first_name);
			customer.setLast_name(last_name);
			customer.setEmail(email);
			customer.setAddress_id(address_id);
			customer.setCreate_date(create_date);
			
			insertAndSelectCustomer(factory, customer);
		}
    	  
			//System.out.println(customer.getCustomer_id());
    		/*Customer customer1 = customerService.getCustomerById(1);
        	System.out.println("first_name" + customer1.getFirst_name());*/
    }
    
    public static void insertAndSelectCustomer(BeanFactory factory,Customer customer){
    	//插入数据
    	CustomerService customerService = factory.getBean("customerService", CustomerService.class);
    	customerService.insertCustomer(customer);   
    	//显示数据
    	Customer customer1 = customerService.getCustomerById(customer.getCustomer_id());
    	Address address =  getAddress(factory, customer1.getAddress_id());
    	System.out.println("您保存的信息为：");
    	System.out.println("first_name:" + customer1.getFirst_name());
    	System.out.println("last_name:" + customer1.getLast_name());
    	System.out.println("email:" + customer1.getEmail());
    	System.out.println("address:" + address.getAddress());
    	System.out.println("create_date:" + customer1.getCreate_date());
	
    }
    public static boolean addressExist(BeanFactory factory,int address_id){
    	AddressService addressService = factory.getBean("addressService", AddressService.class);
    	Address address = addressService.getAddressById(address_id);
    	if (null != address) {
    		return true;
		}else {
			return false;
		}
    }
    public static Address  getAddress(BeanFactory factory,int address_id) {
    	AddressService addressService = factory.getBean("addressService", AddressService.class);
		Address address = addressService.getAddressById(address_id);
		return address;
	}
}
