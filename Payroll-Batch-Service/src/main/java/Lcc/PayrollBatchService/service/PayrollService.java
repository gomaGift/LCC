package Lcc.PayrollBatchService.service;

import Lcc.PayrollBatchService.model.Payroll;
import org.springframework.batch.item.Chunk;

import java.util.Date;
import java.util.List;

public interface PayrollService {
    void save(Payroll payroll);



    Chunk<? extends Payroll> saveAll(Chunk<? extends Payroll> chunk);

    List<Payroll> findPayrollRecordsByDate(String payrollDate);



    double findYtdGrossSalary(String empId, Date startDate);

    double findTaxPaidYearToDate(String empId, Date startDate);
}
