package Lcc.PayrollBatchService.payrollGenerator;

import Lcc.PayrollBatchService.dto.PaySlipEmployeeData;
import Lcc.PayrollBatchService.model.EmployeePayrollDeduction;
import Lcc.PayrollBatchService.model.Payroll;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PayrollDataMapper {

    public Context setData(Payroll payroll, List<EmployeePayrollDeduction> payrollDeductions, PaySlipEmployeeData employeeData){
        Context context = new Context();

        Map<String, Object> stringPayrollMap = new HashMap<>();
        stringPayrollMap.put("payroll", payroll);
        stringPayrollMap.put("payrollDeductions", payrollDeductions);
        stringPayrollMap.put("employeeData", employeeData);

        context.setVariables(stringPayrollMap);
        return context;
    }
}
