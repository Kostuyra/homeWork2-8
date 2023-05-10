package com.example.homework28;

import com.example.homework28.exception.EmployeeAlreadyAddedException;
import com.example.homework28.exception.EmployeeNotFoundException;
import com.example.homework28.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	private final Map<String, Employee> employees;
	private static final int countEmployees = 10;

	public EmployeeService() {
		this.employees = new HashMap<>();
	}

	@Override
	public Employee addEmployee(String firstName, String lastName) {
		checkSize();
		Employee employee = new Employee(firstName, lastName);
		if (checkExistEmployee(employee.fullName())) {
			throw new EmployeeAlreadyAddedException(employee);
		}
		employees.put(employee.fullName(),employee);
		return employee;
	}

	@Override
	public Employee removeEmployee(String firstName, String lastName) {
		Employee employee = new Employee(firstName, lastName);
		if (!checkExistEmployee(employee.fullName())) {
			throw new EmployeeNotFoundException(employee);
		}
		employees.remove(employee.fullName());
		return employee;
	}

	@Override
	public Employee findEmployee(String firstName, String lastName) {
		Employee employee = new Employee(firstName, lastName);
		if (!checkExistEmployee(employee.fullName())) {
			throw new EmployeeNotFoundException(employee);
		}
		return employee;
	}

	@Override
	public Map<String, Employee> allEmployees() {
		return employees;
	}

	private boolean checkExistEmployee(String key) {
		return employees.containsKey(key);
	}

	private boolean checkSize() {
		if (employees.size() == countEmployees) {
			throw new EmployeeStorageIsFullException();
		}
		return true;
	}

}
