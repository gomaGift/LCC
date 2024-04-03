package Lcc.PayrollBatchService.service;

import Lcc.PayrollBatchService.model.EmployeeOnPayroll;
import org.springframework.batch.item.Chunk;

import java.util.List;

public interface EmployeeOnPayrollService {
    List<EmployeeOnPayroll> getAllEmployees();

    void saveAll(Chunk<? extends EmployeeOnPayroll> chunk);

    EmployeeOnPayroll save(EmployeeOnPayroll employee);
}
