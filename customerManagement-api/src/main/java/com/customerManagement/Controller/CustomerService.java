package com.customerManagement.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerManagement.Model.Customer;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	public List<Customer> getAllCustomers()
	{
		List<Customer> customers = new ArrayList<>();
		customerRepo.findAll().forEach(customers::add);
		return customers;
		
	}
	
	public Customer getCustomer(Long id)
	{
		return customerRepo.getOne(id);
	}
	
	public void addCustomer(Customer cust)
	{
		customerRepo.save(cust);
	}
	
	public void updateCustomer(Customer cust)
	{
		customerRepo.save(cust);
	}

	public void deleteCustomer(Long id)
	{
		customerRepo.delete(id);	
	}
	
}
