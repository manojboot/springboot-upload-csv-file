package com.stackoverflow.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stackoverflow.ResponseMessage;
import com.stackoverflow.model.Employee;
import com.stackoverflow.service.EmployeeService;
import com.stackoverflow.util.CommonConstants;
import com.stackoverflow.util.GenericCSVHelper;

@RestController
@RequestMapping("/api/v1/employee/csv")
public class EmployeeController {

	  private EmployeeService employeeService;
	  public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    if (GenericCSVHelper.hasCSVFormat(file)) {
	      try {
	    	employeeService.save(file);
	        message = CommonConstants.UPLOAD_SUCCESS + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = CommonConstants.UPLOAD_FAILURE + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }
	    message = CommonConstants.FILE_MISSING;
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	  }
	  
	  @GetMapping("/list")
	  public ResponseEntity<List<Employee>> getAllEmployees() {
	    try {
	      List<Employee> tutorials = employeeService.getAllEmployees();
	      if (tutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
