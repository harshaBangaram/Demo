package controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dto.EmployeeDTO;
import dto.SalaryAccountDTO;
import entity.Employee;
import exception.EmployeeManagementException;
import service.EmployeeService;
import service.SalaryAccountService;

@Controller(value = "empController")
public class EmployeeController {
	Log logger = LogFactory.getLog(getClass());
	@Autowired
	private EmployeeService empService;
	@Autowired
	private SalaryAccountService salaryAccountService;

	public void addEmployee() throws Throwable {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter employee details");
//		System.out.println("enter empId");
//		long a = sc.nextInt();// int->Integer

		// auto promotion conncept
		// auot boxing and auto unoxing
		System.out.println("enter emp name");
		String empName = sc.next();
		System.out.println("enter phone number");
		String phNumber = sc.next();
		System.out.println("enter the email");
		String email = sc.next();
//		Long employeeId, String empName, String designation, Double salary, String phoneNumber,
//		String email, LocalDate doj

		System.out.println("enter designation");
		String designation = sc.next();
		System.out.println("enter salary");
		Double salaray = sc.nextDouble();

		System.out.println("enter date in format dd/MM/YYYY");
		String date = sc.next();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d = LocalDate.parse(date, dtf);
		EmployeeDTO empDTO = new EmployeeDTO(empName, designation, salaray, phNumber, email, d);
		String scMsg = empService.addEmployee(empDTO);
		System.out.println(scMsg);

	}

	public void viewAllEmployees() {
		System.out.println("fetching employees");
		List<Employee> list = empService.viewAllEmployees();
		list.forEach(System.out::println);
	}

	public void viewEmployee() {
		System.out.println("fetching employee details");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter employee details");
		System.out.println("enter empId");
		long a = sc.nextInt();// int->Integer

		Employee list = empService.viewEmployee(a);
		System.out.println(list);
	}

	public void deleEMployeeWithEMpID() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter employee details");
		System.out.println("enter empId");
		long a = sc.nextInt();// int->Integer
		empService.deleteEmployee(a);
	}

	public void deleteAllEMployees() {

		empService.deleteAllEmployeeData();
		;
	}

	public void searchByDesignation() {
		System.out.println("enter designation");
		Scanner sc = new Scanner(System.in);
		String designation = sc.next();
		empService.searchByDesignation(designation).stream().forEach(System.out::println);
	}

	public void filterEmployessBySalrayRange() {
		System.out.println("enter min salaray ");
		Scanner sc = new Scanner(System.in);
		double minSalary = sc.nextDouble();
		System.out.println(" enter max salaray");
		double maxSalary = sc.nextDouble();
		empService.filterEmployeesBySalarayRange(minSalary, maxSalary).forEach(System.out::println);
	}

	public void filterByDoj() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter date in format dd/MM/YYYY");
		String date = sc.next();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d = LocalDate.parse(date, dtf);
		empService.filterByDOJ(d).forEach(e -> System.out.println(e));

	}

	public void fectchSpecifiedColumns() {
		empService.fetchSpecifiedColumns().forEach(e -> System.out.println(e));
	}

	public void updateEMployeeSalaray() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter salaray");
		System.out.println("enter increment");
		String msg = empService.updateEmployees(sc.nextDouble(), sc.nextDouble());
		logger.info(msg);
	}

	public void addBankDetails() throws EmployeeManagementException {
		System.out.println("enter empid");
		Scanner sc = new Scanner(System.in);
		Long empId = sc.nextLong();
		System.out.println("enter bank details");
		System.out.println("enter account number");
		String accountNo = sc.next();
		System.out.println("enter ifsc code");
		String ifsc = sc.next();
		System.out.println("enter branch name");
		String branch = sc.next();
		System.out.println("enter account holder name");
		String name = sc.next();
		// String accountNumber, String accountHolderName, String ifsc, String branch,
		// Long empId
		SalaryAccountDTO sadto = new SalaryAccountDTO(accountNo, name, ifsc, branch, empId);
		String msg = salaryAccountService.addBankDetails(sadto);
		logger.info(msg);

	}
}
