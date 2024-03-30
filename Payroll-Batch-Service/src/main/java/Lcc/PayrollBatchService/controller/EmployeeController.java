package Lcc.PayrollBatchService.controller;

import Lcc.PayrollBatchService.model.Employee;
import Lcc.PayrollBatchService.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
    @Autowired
    private  EmployeeService employeeService;

    @GetMapping("/employee/{employeeId}/process")
    public ResponseEntity<String> processEmployee(@PathVariable String employeeId){
        Optional<Employee> employee = employeeService.findById(employeeId);

        // employee processing e.g salary increment
        if (employee.isPresent()){
            Employee employee1 = employee.get();
//            employee1.setSalary(employee1.getSalary() * 2);
            employeeService.save(employee1);
            return ResponseEntity.ok("Employee Process successfully");
        }

        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");

    }

}
