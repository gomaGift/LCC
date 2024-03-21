package Lcc.PayrollBatchService.controller;

import Lcc.PayrollBatchService.model.Employee;
import Lcc.PayrollBatchService.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employee/{employeeId}/process")
    public ResponseEntity<String> processEmployee(@PathVariable Long employeeId){
        Optional<Employee> employee = employeeService.findById(employeeId);

        // employee processing e.g salary increment
        if (employee.isPresent()){
            Employee employee1 = employee.get();
            employee1.setSalary(employee1.getSalary() * 2);
            employeeService.save(employee1);
            return ResponseEntity.ok("Employee Process successfully");
        }

        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");



    }
}
