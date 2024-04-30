package Lcc.PayrollBatchService.payrollGenerator;

import Lcc.PayrollBatchService.dto.PaySlipEmployeeData;
import Lcc.PayrollBatchService.model.EmployeePayrollDeduction;
import Lcc.PayrollBatchService.model.Payroll;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PayrollPdfGenerator {

    private final PayrollDataMapper payrollDataMapper;
    private final PayrollHtmlPdfConverter payrollHtmlPdfConverter;
    private final SpringTemplateEngine templateEngine;

    public void generatePayroll(Payroll payroll, List<EmployeePayrollDeduction> employeePayrollDeductions, PaySlipEmployeeData employeeData, String empFullname){
        String finalHtml = null;
        Context context = payrollDataMapper.setData(payroll, employeePayrollDeductions, employeeData);
        finalHtml = templateEngine.process("pay_slip", context);
        payrollHtmlPdfConverter.htmlToPdf(finalHtml, empFullname);
    }
}
