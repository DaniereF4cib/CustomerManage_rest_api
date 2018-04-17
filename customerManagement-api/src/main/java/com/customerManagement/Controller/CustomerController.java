package com.customerManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.customerManagement.Model.Customer;


@RestController
@RequestMapping(value="/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	

	@GetMapping(value="/customers")
	public List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@RequestMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable Long id)
	{
		return customerService.getCustomer(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/customers")
	public void addCustomer(@RequestBody Customer customer)
	{
		customerService.addCustomer(customer);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/customers/{id}")
	public void updateCustomer(@RequestBody Customer customer, @PathVariable int id)
	{
		customerService.updateCustomer(customer);
	}
	
	//@RequestMapping(method=RequestMethod.DELETE, value="/customers/{id}")
	@DeleteMapping(value="/customers/{id}")
	public void deleteCustomer(@PathVariable Long id)
	{
		customerService.deleteCustomer(id);
	}
	
}

