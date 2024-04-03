package Lcc.PayrollBatchService.service;

import Lcc.PayrollBatchService.model.Payroll;
import org.springframework.batch.item.Chunk;

import java.util.List;

public interface PayrollService {
    void save(Payroll payroll);



    void saveAll(Chunk<? extends Payroll> chunk);

    List<Payroll> findPayrollRecordsByDate(String payrollDate);
}
