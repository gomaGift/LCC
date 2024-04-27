package Lcc.PayrollBatchService.service;

import Lcc.PayrollBatchService.model.Employee;
import org.springframework.batch.item.Chunk;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

 

    Optional<Employee> findById(String employeeId);

    void saveAll(Chunk<? extends Employee> chunk);

    void save(Employee employee1);

    String findPositionByEmployeeId(String empId);
}
