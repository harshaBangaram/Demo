package service;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import controller.EmployeeController;

@SpringBootApplication
//@enableAutoConfiguration
//@Configuration
//CpmponentScan
public class Main {

	public static void main(String[] args) throws Throwable {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		EmployeeController ec = context.getBean(EmployeeController.class);

		// ec.addEmployee();
		// ec.viewAllEmployees();
		// ec.viewEmployee();
		// ec.deleEMployeeWithEMpID();
		// ec.deleteAllEMployees();
		// ec.searchByDesignation();
		// ec.filterEmployessBySalrayRange();
		// ec.filterByDoj();
		// ec.fectchSpecifiedColumns();
		// ec.updateEMployeeSalaray();
		//ec.addBankDetails();
	}

}