package com.stackoverflow.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.stackoverflow.model.Employee;
import com.stackoverflow.repository.EmployeeRepository;
import com.stackoverflow.util.CommonConstants;
import com.stackoverflow.util.GenericCSVHelper;

@Transactional
@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public void save(MultipartFile file) {
			List<Employee> employees;
		 try {
		      employees = GenericCSVHelper.csvToEmployeeList(file.getInputStream());
		      employeeRepository.saveAll(employees);
		    } catch (IOException e) {
		      throw new RuntimeException(CommonConstants.CSV_SAVE_ERROR + e.getMessage());
		    }
		    
		 	//  int s = 100/0;
		      List<Employee> employeesWithNameStartingWithM = employees.stream().filter(x->x.getFirstName().startsWith("M"))
		    		  		.collect(Collectors.toList());
		      for(Employee e : employeesWithNameStartingWithM) {
		    	  e.setSalary(68500.00);
		    	  employeeRepository.save(e);
		      }
	}
	
	public List<Employee> getAllEmployees() {
		    return employeeRepository.findAll();
		  }
}
