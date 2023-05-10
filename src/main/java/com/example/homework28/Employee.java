package com.example.homework28;

public class Employee {
	private final String firstName;
	private final String lastName;

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "ФИО: " + firstName + " " + lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String fullName(){
		return firstName + " " + lastName;
	}
	@Override
	public int hashCode() {
		return java.util.Objects.hash(firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Employee employee2 = (Employee) obj;
		return firstName.equals(employee2.getFirstName()) && lastName.equals(employee2.getLastName());

	}
}
