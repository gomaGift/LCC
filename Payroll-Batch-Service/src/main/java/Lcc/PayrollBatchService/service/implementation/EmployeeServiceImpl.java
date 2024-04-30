package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.model.Employee;
import Lcc.PayrollBatchService.respository.EmployeeRepository;
import Lcc.PayrollBatchService.service.EmployeeService;
import org.springframework.batch.item.Chunk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveAll(Chunk<? extends Employee> chunk) {
        employeeRepository.saveAll(chunk);
    }

    @Override
    public void save(Employee employee1) {
        employeeRepository.save(employee1);
    }

    @Override
    public String findPositionByEmployeeId(String empId) {
        return employeeRepository.findPositionByEmployeeId(empId);
    }

    @Override
    public LocalDate findEmployeeDateOfFirstEngagementByEmployeeId(String employeeId) {
        return employeeRepository.findDateEmployeeDateOfFirstEngagementByEmpId(employeeId);
    }

    @Override
    public Employee findEmployeeByEmployeeId(String employeeId) {
        return employeeRepository.findByEmployeeByEmployeeId(employeeId);
    }

    @Override
    public Optional<Employee> findById(String employeeId) {
        return employeeRepository.findById(employeeId);
    }
}
