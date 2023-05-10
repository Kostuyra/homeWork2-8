package com.example.homework28;
import java.util.Map;


public interface EmployeeServiceInterface {

	Employee addEmployee(String firstName, String lastName);

	Employee removeEmployee(String firstName, String lastName);

	Employee findEmployee(String firstName, String lastName);

	Map<String, Employee> allEmployees();
}
