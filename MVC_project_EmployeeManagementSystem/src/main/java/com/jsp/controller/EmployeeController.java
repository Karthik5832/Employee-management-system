package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dao.EmployeeDao;
import com.jsp.dto.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao dao;
	
	//to insert employee object
	
	@RequestMapping("/emp")
	public ModelAndView getInsertionForm() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee",new Employee());
		mv.setViewName("create.jsp");
		return mv;
		
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String saveEmployee(@ModelAttribute Employee employee) {
		
		dao.insertEmployee(employee);
		return "EMPLOYEE DETAILS STORED SUCCESSFULLY";
	}
	
	//to search for an employee
	@RequestMapping("/search")
	public ModelAndView getSearchForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", new Employee());
		mv.setViewName("get.jsp");
		return mv;
	}
	
	@RequestMapping("/view")
	public ModelAndView displayEmployee(@ModelAttribute Employee employee) {
		
		int id = employee.getId();
		
		Employee emp = dao.searchEmployee(id);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee",emp);
		mv.setViewName("display.jsp");
		return mv;
	}
	
	//to delete an employee
	
	@RequestMapping("/remove")
	public ModelAndView getDeleteForm() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee",new Employee());
		mv.setViewName("delect.jsp");
		return mv;
	}
	
	@RequestMapping("/delect")
	@ResponseBody
	public String delectEmployee(@ModelAttribute Employee employee ) {
		
		int id = employee.getId();
		String result = dao.deleteEmployee(id);
		return result;
	}
	
	@RequestMapping("/update")
	public ModelAndView getUpdateForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee",new Employee());
		mv.setViewName("edit.jsp");
		return mv;
		
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String editEmployeeDetails(@ModelAttribute Employee employee) {
		Employee existingEmp = dao.searchEmployee(employee.getId());
		if(existingEmp != null) {
			existingEmp.setName(employee.getName());
			existingEmp.setPhone(employee.getPhone());
			dao.updateEmployee(existingEmp);
			return "EMPLOYEE DETAILS UPDATES SUCCESSFULLY...";
		} else {
			return "EMPLOYEE TD DOESNT EXIST ENTER VALID ID....";
		}
	}
	
	@RequestMapping("/getemp")
	public ModelAndView displayAllEmployee() {
		ModelAndView mv = new ModelAndView();
		List<Employee> list = dao.getAllEmployees();
		mv.addObject("employeelist",list);
		mv.setViewName("displayAll.jsp");
		return mv;
	}
	
}
