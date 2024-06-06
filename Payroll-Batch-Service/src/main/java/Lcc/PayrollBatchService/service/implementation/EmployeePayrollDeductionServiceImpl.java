package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.model.EmployeePayrollDeduction;
import Lcc.PayrollBatchService.respository.EmployeePayrollDeductionRepository;
import Lcc.PayrollBatchService.service.EmployeePayrollDeductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeePayrollDeductionServiceImpl implements EmployeePayrollDeductionService {

    @Autowired
    private  EmployeePayrollDeductionRepository employeePayrollDeductionRepository;
    @Override
    public void add(EmployeePayrollDeduction employeePayrollDeduction) {
        employeePayrollDeductionRepository.save(employeePayrollDeduction);
    }

    @Override
    public List<EmployeePayrollDeduction> findAllDeductionsByEmployeeNumberAndDate(String employeeId, String paymentDate) {
        return employeePayrollDeductionRepository.findAllByEmployeeNumberAndDate(employeeId,paymentDate);
    }

    @Override
    public double getPensionYearToDate(String employeeId, String deductionType, Date startDate) {
        return employeePayrollDeductionRepository.calculatePensionYearToDate(employeeId,deductionType, startDate);
    }


}
