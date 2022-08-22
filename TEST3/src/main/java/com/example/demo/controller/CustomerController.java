package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerRepo;
import com.example.demo.model.Customer;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepo repo;
	
	
	
	@PostMapping(path="/cust",consumes= {"application/json"})
	
	public Customer addcustome(@RequestBody Customer customer) {
		
		repo.save(customer);
		
		return customer;
	}
	
	
	
	@GetMapping("/customs")

	 public List<Customer> getcustomers()

	 {

	 return repo.findAll();

	 }
	
	
	@GetMapping("/cust/{c_id}")

	 public Optional<Customer> getCustomer(@PathVariable("c_id")int aid)

	 {
		 System.out.println(aid);
	 return repo.findById(aid);

	 }

	@PutMapping(path="/cust",consumes= {"application/json"})

	 public Customer saveOrUpdateAlien(@RequestBody Customer customer)

	 {

	 repo.save(customer);

	 return customer;

	 }
	@SuppressWarnings("deprecation")
	@DeleteMapping("/cust/{c_id}")
	public String deleteAlien(@PathVariable int c_id)

	 {

	
	
	
	Customer a = repo.getOne(c_id);

	 repo.delete(a);

	 return "deleted";

	 }

}
	

