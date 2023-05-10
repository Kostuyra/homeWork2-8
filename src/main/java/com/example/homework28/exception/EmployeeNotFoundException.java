package com.example.homework28.exception;

import com.example.homework28.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(Employee employee){
		super("Сотрудник " + employee.toString() +" не найден");
	}
}
