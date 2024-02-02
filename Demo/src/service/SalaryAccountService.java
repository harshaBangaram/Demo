package service;

import dto.SalaryAccountDTO;
import exception.EmployeeManagementException;

public interface SalaryAccountService {
public String addBankDetails(SalaryAccountDTO dto) throws EmployeeManagementException;
}
