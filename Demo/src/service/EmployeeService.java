package service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.cglib.core.Local;

import dto.EmployeeDTO;
import entity.Employee;

//@@ -19,4 +22,10 @@ 
public interface EmployeeService {
	public List<Employee> searchByDesignation(String designation);

	public List<EmployeeDTO> filterEmployeesBySalarayRange(Double minSalaray, Double maxSalaray);

	public List<EmployeeDTO> filterByDOJ(LocalDate date);

	public List<Employee> fetchSpecifiedColumns();

	public String updateEmployees(Double currentSalaray,Double increment);
}