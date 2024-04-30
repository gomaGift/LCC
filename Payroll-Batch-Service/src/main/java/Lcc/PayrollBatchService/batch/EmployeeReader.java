package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.model.EmployeeOnPayroll;
import Lcc.PayrollBatchService.service.EmployeeOnPayrollService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeReader implements ItemReader<EmployeeOnPayroll> {

    @Autowired
    private EmployeeOnPayrollService employeeOnPayrollService;
    private List<EmployeeOnPayroll> employeeList;
    private int employeeIdx = 0;

    @Override
    public EmployeeOnPayroll read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
             if (employeeList == null){
                 employeeList = employeeOnPayrollService.getAllEmployees();
             }
             EmployeeOnPayroll employee = null;
             if (employeeIdx < employeeList.size()){
                 employee = employeeList.get(employeeIdx++);
             }
             else {
                 employeeList = null;
                 employeeIdx = 0;
             }
             return  employee;
    }
}
