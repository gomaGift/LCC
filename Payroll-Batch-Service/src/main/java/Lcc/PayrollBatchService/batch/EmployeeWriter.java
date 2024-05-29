package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.dto.PaySlipEmployeeData;
import Lcc.PayrollBatchService.model.*;
import Lcc.PayrollBatchService.payrollGenerator.PayrollPdfGenerator;
import Lcc.PayrollBatchService.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeWriter implements ItemWriter<Payroll> {


   private final PayrollService payrollService;
   private final EmployeePayrollDeductionService employeePayrollDeductionService;
   private final EmployeePersonalDataService employeePersonalDataService;
   private final PayrollPdfGenerator pdfGenerator;
   private final EmployeeService employeeService;
   private final EmployeeBankDetailService employeeBankDetailService;

    @Override
    public void write(Chunk<? extends Payroll> chunk) throws Exception {
        Chunk<? extends Payroll> chunks = payrollService.saveAll(chunk);

       chunks.forEach(payroll -> {
           EmployeePersonalData employeePersonalData = employeePersonalDataService.findEmployeeDataByEmployeeNumber(payroll.getKey().getEmployeeId());
           // retrieve employee bank details
           EmployeeBankDetails employeeBankDetails = employeeBankDetailService.findEmployeeBankDetailByEmployeeNumber(payroll.getKey().getEmployeeId());
           // access other employee data
           Employee employeeDetails = employeeService.findEmployeeByEmployeeId(payroll.getKey().getEmployeeId());
           String empFullname = employeePersonalData.getFirstname() + " " + employeePersonalData.getSurname();
           PaySlipEmployeeData empInfo = new PaySlipEmployeeData(payroll.getKey().getEmployeeId(),empFullname,employeePersonalData.getNrc(),employeePersonalData.getNrc(), employeeDetails.getDateAppointedToCurrentPosition(), employeeDetails.getEmploymentType(),"name","name",employeeBankDetails.getBranch(),"name","name",employeeBankDetails.getBankName(),employeeBankDetails.getAccountNumber(),"name" ,"");
           List<EmployeePayrollDeduction> employeePayrollDeductions = employeePayrollDeductionService.findAllDeductionsByEmployeeNumberAndDate(payroll.getKey().getEmployeeId(), payroll.getKey().getPaymentDate());

           pdfGenerator.generatePayroll(payroll, employeePayrollDeductions, empInfo, empFullname);
       });
    }
}
