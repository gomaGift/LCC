package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.model.Employee;
import Lcc.PayrollBatchService.model.EmployeeOnPayroll;
import Lcc.PayrollBatchService.respository.EmployeesOnPayrollRepository;
import Lcc.PayrollBatchService.service.EmployeeOnPayrollService;
import org.springframework.batch.item.Chunk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeOnPayrollImplementation implements EmployeeOnPayrollService {
    @Autowired
    private EmployeesOnPayrollRepository employees;


    @Override
    public List<EmployeeOnPayroll> getAllEmployees() {
        return employees.findAll();
    }

    @Override
    public void saveAll(Chunk<? extends EmployeeOnPayroll> chunk) {
        employees.saveAll(chunk);
    }
}
