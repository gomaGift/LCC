package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.model.Employee;
import Lcc.PayrollBatchService.model.EmployeeOnPayroll;
import Lcc.PayrollBatchService.service.EmployeeOnPayrollService;
import Lcc.PayrollBatchService.service.EmployeeService;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeWriter implements ItemWriter<EmployeeOnPayroll> {

    @Autowired
    private EmployeeOnPayrollService employeeService;



    @Override
    public void write(Chunk<? extends EmployeeOnPayroll> chunk) throws Exception {
        employeeService.saveAll(chunk);
    }
}
