package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.model.Employee;
import Lcc.PayrollBatchService.service.EmployeeService;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeWriter implements ItemWriter<Employee> {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void write(Chunk<? extends Employee> chunk) throws Exception {
        employeeService.saveAll(chunk);
    }
}
