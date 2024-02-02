package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.SalaryAccountDTO;
import entity.Employee;
import entity.SalaryAccount;
import exception.EmployeeManagementException;
import repository.EmpRepository;
import repository.SalAccRepository;

@Service(value = "salaryAcntService")
public class SalAccServIMp implements SalaryAccountService {

	@Autowired
	private SalAccRepository salaryAccountRepository;

	@Autowired
	private EmpRepository employeeRepository;

	@Override
	@Transactional
	public String addBankDetails(SalaryAccountDTO dto) throws EmployeeManagementException {
		;

		Optional<Employee> optEmp = employeeRepository.findById(dto.getEmpId());
		Employee emp = optEmp
				.orElseThrow(() -> new EmployeeManagementException("no employee found with id " + dto.getEmpId()));

		SalaryAccount newSalaryAccount = new SalaryAccount();// empty
		newSalaryAccount.setAccountNumber(dto.getAccountNumber());
		newSalaryAccount.setAccountHolderName(dto.getAccountHolderName());
		newSalaryAccount.setIFSC(dto.getIfsc());
		newSalaryAccount.setBranch(dto.getBranch());
		// all values except actId
		newSalaryAccount.setEmployee(emp);
		SalaryAccount sa = salaryAccountRepository.save(newSalaryAccount);
		return "account added successfully with id " + sa.getAcId() + "for emp id " + dto.getEmpId();
	}

}