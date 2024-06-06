package Lcc.PayrollBatchService.payrollGenerator;

import Lcc.PayrollBatchService.dto.PaySlipEmployeeData;
import Lcc.PayrollBatchService.model.EmployeePayrollDeduction;
import Lcc.PayrollBatchService.model.Payroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.List;


@Component
public class PayrollPdfGenerator {

    @Autowired
    private  PayrollDataMapper payrollDataMapper;
    @Autowired
    private  PayrollHtmlPdfConverter payrollHtmlPdfConverter;
    @Autowired
    private  SpringTemplateEngine templateEngine;

    public byte[] generatePayroll(Payroll payroll, List<EmployeePayrollDeduction> employeePayrollDeductions, PaySlipEmployeeData employeeData, String empFullname){
        String finalHtml = null;
        Context context = payrollDataMapper.setData(payroll, employeePayrollDeductions, employeeData);
        finalHtml = templateEngine.process("pay_slip", context);
       return payrollHtmlPdfConverter.htmlToPdf(finalHtml, empFullname);
    }
}
