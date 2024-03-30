package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.respository.EmployeeOtherDeductionRepository;
import Lcc.PayrollBatchService.service.EmployeeOtherDeductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeOtherDeductionServiceImpl implements EmployeeOtherDeductionService {

    private final EmployeeOtherDeductionRepository employeeOtherDeductionRepository;

    @Override
    public List<String> findOtherDeductionByEmployeeId(String empId) {
        return employeeOtherDeductionRepository.findOtherDeductionTypeByEmployeeId(empId);
    }
}
