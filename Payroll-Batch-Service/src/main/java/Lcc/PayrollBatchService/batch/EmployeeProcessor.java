package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

    // Do processing here
    @Override
    public Employee process(Employee employee) throws Exception {
        employee.setSalary(employee.getSalary() * 0.1 + employee.getSalary());
        log.info("employee id {}, salary {}", employee.getId(), employee.getSalary());
        return employee;
    }
}

