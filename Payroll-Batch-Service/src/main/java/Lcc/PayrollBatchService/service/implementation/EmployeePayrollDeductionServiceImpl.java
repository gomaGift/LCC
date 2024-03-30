package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.model.EmployeePayrollDeduction;
import Lcc.PayrollBatchService.respository.EmployeePayrollDeductionRepository;
import Lcc.PayrollBatchService.service.EmployeePayrollDeductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeePayrollDeductionServiceImpl implements EmployeePayrollDeductionService {

    private final EmployeePayrollDeductionRepository employeePayrollDeductionRepository;
    @Override
    public void add(EmployeePayrollDeduction employeePayrollDeduction) {
        employeePayrollDeductionRepository.save(employeePayrollDeduction);
    }
}
