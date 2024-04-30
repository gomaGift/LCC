package Lcc.PayrollBatchService.service;

import Lcc.PayrollBatchService.model.EmployeePersonalData;

public interface EmployeePersonalDataService {
    EmployeePersonalData findEmployeeDataByEmployeeNumber(String employeeId);
}
