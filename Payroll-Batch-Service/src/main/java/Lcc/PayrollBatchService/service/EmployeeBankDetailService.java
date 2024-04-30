package Lcc.PayrollBatchService.service;

import Lcc.PayrollBatchService.model.EmployeeBankDetails;

public interface EmployeeBankDetailService {
    EmployeeBankDetails findEmployeeBankDetailByEmployeeNumber(String employeeId);
}
