package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.model.EmployeePayrollDeduction;
import Lcc.PayrollBatchService.respository.EmployeePayrollDeductionRepository;
import Lcc.PayrollBatchService.service.EmployeePayrollDeductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeePayrollDeductionServiceImpl implements EmployeePayrollDeductionService {

    private final EmployeePayrollDeductionRepository employeePayrollDeductionRepository;
    @Override
    public void add(EmployeePayrollDeduction employeePayrollDeduction) {
        employeePayrollDeductionRepository.save(employeePayrollDeduction);
    }

    @Override
    public List<EmployeePayrollDeduction> findAllDeductionsByEmployeeNumberAndDate(String employeeId, String paymentDate) {
        return employeePayrollDeductionRepository.findAllByEmployeeNumberAndDate(employeeId,paymentDate);
    }


}
