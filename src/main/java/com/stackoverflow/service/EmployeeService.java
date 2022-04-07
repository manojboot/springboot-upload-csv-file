package com.stackoverflow.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stackoverflow.model.Employee;
import com.stackoverflow.repository.EmployeeRepository;
import com.stackoverflow.util.CommonConstants;
import com.stackoverflow.util.GenericCSVHelper;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public void save(MultipartFile file) {
		 try {
		      List<Employee> tutorials = GenericCSVHelper.csvToEmployeeList(file.getInputStream());
		      employeeRepository.saveAll(tutorials);
		    } catch (IOException e) {
		      throw new RuntimeException(CommonConstants.CSV_SAVE_ERROR + e.getMessage());
		    }
		 
	}
	
	public List<Employee> getAllEmployees() {
		    return employeeRepository.findAll();
		  }
}
