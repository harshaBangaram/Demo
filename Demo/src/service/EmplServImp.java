package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dto.EmployeeDTO;
import entity.Employee;
import repository.EmpRepository;
@Service(value = "empServiceImpl")
@Transactional
public class EmplServImp implements EmployeeService {
	@Autowired
	private EmpRepository employeeRepository;
	@Override
	public String addEmployee(EmployeeDTO emp) throws Exception {
		Employee e = employeeRepository.findByPhoneNumber(emp.getPhoneNumber());
		if (e != null) {
			// throws new RuntimeException("phone number already registered " +
			// emp.getPhoneNumber());
		}
		Employee newEntity = new Employee(emp.getEmpName(), emp.getDesignation(), emp.getSalary(), emp.getPhoneNumber(),
				emp.getEmail(), emp.getDoj());
		employeeRepository.save(newEntity);
		// throw new Exception("generated exception after invoking save");
		return "";
	}
	@Override
	public List<Employee> viewAllEmployees() {
		Iterable<Employee> itrEmp = employeeRepository.findAll();
		List<Employee> list = new ArrayList<Employee>();
		itrEmp.forEach((Employee e) -> list.add(e));
		return list;
	}
	@Override
	public Employee viewEmployee(Long empId) {
		Optional<Employee> optEmployee = employeeRepository.findById(empId);
		Employee emp = optEmployee.orElseThrow(() -> new RuntimeException("no employee found with id " + empId));
		return emp;
	}
	@Override
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
		System.out.println("employee deleted successfully with " + empId);
	}
	@Override
	public void deleteAllEmployeeData() {
		employeeRepository.deleteAll();
		System.out.println("all employees deleted");
	}
	@Override
	public List<Employee> searchByDesignation(String designation) {
		return employeeRepository.findByDesignation(designation);
	}

	@Override
	public List<EmployeeDTO> filterEmployeesBySalarayRange(Double minSalaray, Double maxSalaray) {
		List<Employee> repoEmployees = employeeRepository.findEmployeesDataBetweenSalaraies(minSalaray,maxSalaray);
		List<Employee> repoEmployees = employeeRepository.findEmployeesDataBetweenSalaraies(minSalaray, maxSalaray);
		List<EmployeeDTO> dtos = repoEmployees.stream().map(e -> new EmployeeDTO(e.getEmpName(), e.getDesignation(),
				e.getSalary(), e.getEmail(), e.getPhoneNumber(), e.getDoj())).collect(Collectors.toList());
		if (dtos.isEmpty())
@@ -87,4 +87,27 @@ public List<EmployeeDTO> filterEmployeesBySalarayRange(Double minSalaray, Double
		return dtos;
	}

	@Override
	public List<EmployeeDTO> filterByDOJ(LocalDate date) {
		List<Employee> repoEmployees = employeeRepository.findByDoj1(date);
		List<EmployeeDTO> dtos = repoEmployees.stream().map(e -> new EmployeeDTO(e.getEmpName(), e.getDesignation(),
				e.getSalary(), e.getEmail(), e.getPhoneNumber(), e.getDoj())).collect(Collectors.toList());
		if (dtos.isEmpty())
			throw new RuntimeException(String.format("no employees found in the provided date %s ", date));
		return dtos;
	}

	@Override
	public List<Employee> fetchSpecifiedColumns() {
		// TODO Auto-generated method stub
		return employeeRepository.fetchOnlySpecifiedColumns();
	}

	@Override
	public String updateEmployees(Double currentSalaray,Double increment) {
		// TODO Auto-generated method stub
		employeeRepository.updateEmployeeSalaray(currentSalaray,increment);
		return "employees salaries updated succesfully";
	}

}