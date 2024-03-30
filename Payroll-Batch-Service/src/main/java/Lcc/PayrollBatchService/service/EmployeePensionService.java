package Lcc.PayrollBatchService.service;

public interface EmployeePensionService {
    String findPensionTypeByEmployeeId(String empId);

    double findEmployeePercentageByPensionType(String pensionType);
}
