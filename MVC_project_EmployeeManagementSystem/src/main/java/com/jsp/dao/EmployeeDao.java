package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.dto.Employee;


@Repository
public class EmployeeDao {
	
	@Autowired
	EntityManager manager;
	
	@Autowired
	EntityTransaction transaction;
	
	// to insert employee object into DB
	public void insertEmployee(Employee employee) {
		
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}
	
	//to search for an employee based on ID
	public Employee searchEmployee(int id) {
		
		Employee employee = manager.find(Employee.class, id);
		return employee;
	}

	//to delete an employee object from DB
	public String deleteEmployee(int id) {
		
		Employee employee = manager.find(Employee.class, id);
		if(employee != null) {
			transaction.begin();
			manager.remove(employee);
			transaction.commit();
			return "EMPLOYEE DETAILS WITH ID " + id + " HAS BENN REMOVED SUCCESSFULLY.";
		}
		else {
			return "ID DOESN'T EXIT. PLEASE ENTER VALID EMPLOYEE ID.";
		}
		
	}
	//to update employee in DB
	public void updateEmployee(Employee newEmp) {
			
		transaction.begin();
		manager.merge(newEmp);
		transaction.commit();
	}
	
	//to display all employee details
	public List<Employee> getAllEmployees(){
		
		Query queue = manager.createQuery("select e from Employee e");
		List<Employee> employeeList = queue.getResultList();
		return employeeList;
	}

}
