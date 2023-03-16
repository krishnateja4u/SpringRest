package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dto.EmployeeDto;
import com.practice.entity.Employee;
import com.practice.service.EmployeeService;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

	@Autowired
	EmployeeService employeeservice;
	
	//This is for saving the employees

	@PostMapping("/save")
	public void saveEmployees(@RequestBody EmployeeDto employeedto) {

		employeeservice.saveEmployeeDetails(convertDtotoEntity(employeedto));

	}

	@GetMapping("/fetchEmpdetails")

	public List<EmployeeDto> fetchEmployeeDetails() {
		List<EmployeeDto> e = employeeservice.fetchEmployeeDetails();

		return e;

	}

	@GetMapping("/fetchByName/{id}")
	public List<EmployeeDto> fetchEmployeeDetailsByName(@PathVariable("id") Integer id) {
		return employeeservice.fetchEmployeeDetailsByName(id);

	}

	@DeleteMapping("/deleteByid/{id}")

	public void deleteEmployeeById(@PathVariable("id") Integer id) {
		
	employeeservice.deleteEmployeeById(id);

	}

	public Employee convertDtotoEntity(EmployeeDto employeedto) {
		// TODO Auto-generated method stub
		System.out.println("printing details ::" + employeedto.getName());
		Employee e = new Employee();
		e.setId(employeedto.getEmployeeId());
		e.setName(employeedto.getName());
		e.setSalary(employeedto.getSalary());
		e.setDepartment(employeedto.getDepartment());

		e.setEmail(employeedto.getEmail());

		return e;

	}

}
