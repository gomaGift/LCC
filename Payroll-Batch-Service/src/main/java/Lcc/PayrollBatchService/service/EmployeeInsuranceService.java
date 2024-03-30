package Lcc.PayrollBatchService.service;

import Lcc.PayrollBatchService.model.Insurance;

import java.util.List;

public interface EmployeeInsuranceService {


    List<String> findInsuranceTypeByEmployeeId(String empId);
}
