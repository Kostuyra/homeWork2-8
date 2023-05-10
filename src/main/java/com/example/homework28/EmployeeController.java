package com.example.homework28;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeServiceInterface employeeServiceInterface;

	public EmployeeController(EmployeeServiceInterface employeeServiceInterface) {
		this.employeeServiceInterface = employeeServiceInterface;
	}

	@GetMapping("/add")
	Employee addEmployee(@RequestParam() String firstName, @RequestParam() String lastName) {
		return employeeServiceInterface.addEmployee(firstName, lastName);
	}


	@GetMapping("/delete")
	Employee removeEmployee(@RequestParam() String firstName, @RequestParam() String lastName) {
		return employeeServiceInterface.removeEmployee(firstName, lastName);
	}

	@GetMapping("/find")
	Employee findEmployee(@RequestParam() String firstName, @RequestParam() String lastName) {
	return employeeServiceInterface.findEmployee(firstName, lastName);
	}

	@GetMapping()
	Map<String, Employee> allEmployees() {
		return employeeServiceInterface.allEmployees();
	}


}
