package com.stackoverflow.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.stackoverflow.model.Employee;

public class GenericCSVHelper {
	
	  static String[] HEADERs = { "Id", "Title", "Description", "Published" };
	  public static boolean hasCSVFormat(MultipartFile file) {
	    if (!CommonConstants.CONTENT_TYPE.equals(file.getContentType())) {
	      return false;
	    }
	    return true;
	  }
	
	public static List<Employee> csvToEmployeeList(InputStream is){
		
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader()
					.withIgnoreHeaderCase().withTrim());){
			
			List<Employee> list = new ArrayList<>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for(CSVRecord record : csvRecords) {
				Employee employee = new Employee(
						record.get("first_name"),
						record.get("last_name"),
						record.get("email"),
						record.get("gender")
				);
				list.add(employee);
			}
			return list;
		} 
		catch (IOException e) {
		      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
			}
		}
	}

