package com.practice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dto.EmployeeDto;
import com.practice.entity.Employee;
import com.practice.repository.EmployeeRepository;
@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository emprepository;
	
	public void saveEmployeeDetails(Employee e) {
		
		emprepository.save(e);
		
	}

	public List<EmployeeDto> fetchEmployeeDetails() {
		// TODO Auto-generated method stub
		
		List<Employee> employeedtails= emprepository.findAll();
		
		List<Employee> employee=employeedtails.stream().
				filter(e->e.getName()!=null).collect(Collectors.toList());
		List<EmployeeDto> empdtoList=convertEntitytoDto(employee);
		
		return empdtoList;
		
		
		
	}

	public List<EmployeeDto> convertEntitytoDto(List<Employee> employee) {
		// TODO Auto-generated method stub
		EmployeeDto dto=null;
		List<EmployeeDto> dtoList=new ArrayList<EmployeeDto>();
		for(Employee ee:employee) {
			dto=new EmployeeDto();
			dto.setName(ee.getName());
			dto.setEmail(ee.getEmail());
			dto.setDepartment(ee.getDepartment());
			dto.setSalary(ee.getSalary());
			dto.setEmployeeId(ee.getId());
			
			dtoList.add(dto);
			
		}
		
		return dtoList;
		
		
	}

	public List<EmployeeDto> fetchEmployeeDetailsByName(Integer id) {
		
	Optional<Employee> emp=emprepository.findById(id);
	
	
	List<Employee> empone= emp.stream().collect(Collectors.toList());
	
	List<EmployeeDto> dto=convertEntitytoDto(empone);
	
	return dto;
	
		// TODO Auto-generated method stub
		
	}

	public void deleteEmployeeById(Integer id) {
		
		emprepository.deleteById(id);
		
		
		// TODO Auto-generated method stub
		
	}
	
	
}
