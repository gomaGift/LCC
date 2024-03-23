package Lcc.PayrollBatchService.controller;

import Lcc.PayrollBatchService.model.Employee;
import Lcc.PayrollBatchService.service.EmployeePdfGenerator;
import Lcc.PayrollBatchService.service.EmployeeService;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    @GetMapping(value = "/export-to-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> employeeReport()  throws IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        ByteArrayInputStream bis = EmployeePdfGenerator.generate(employees);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=employees.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
