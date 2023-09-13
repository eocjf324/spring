package com.yedam.app.emp.service;

import lombok.Data;

@Data
public class EmpVO {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String hireDate;
	private String jobId;
	private String departmentId;
	private String salary;
}
