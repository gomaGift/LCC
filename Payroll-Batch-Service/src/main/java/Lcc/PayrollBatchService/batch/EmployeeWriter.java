package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.model.Employee;
import Lcc.PayrollBatchService.model.EmployeeOnPayroll;
import Lcc.PayrollBatchService.model.Payroll;
import Lcc.PayrollBatchService.service.EmployeeOnPayrollService;
import Lcc.PayrollBatchService.service.EmployeeService;
import Lcc.PayrollBatchService.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeWriter implements ItemWriter<Payroll> {


   private final PayrollService payrollService;
    @Override
    public void write(Chunk<? extends Payroll> chunk) throws Exception {
        payrollService.saveAll(chunk);
    }
}
