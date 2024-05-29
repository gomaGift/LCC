package Lcc.PayrollBatchService.service;

import Lcc.PayrollBatchService.model.EmployeePayrollDeduction;

import java.util.Date;
import java.util.List;

public interface EmployeePayrollDeductionService {
    void add(EmployeePayrollDeduction employeePayrollDeduction);


    List<EmployeePayrollDeduction> findAllDeductionsByEmployeeNumberAndDate(String employeeId, String paymentDate);

    double getPensionYearToDate(String employeeId, String deductionType, Date startDate);
}
