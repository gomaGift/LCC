package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.respository.EmployeeOtherDeductionRepository;
import Lcc.PayrollBatchService.service.EmployeeOtherDeductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeOtherDeductionServiceImpl implements EmployeeOtherDeductionService {

    @Autowired
    private  EmployeeOtherDeductionRepository employeeOtherDeductionRepository;

    @Override
    public List<String> findOtherDeductionByEmployeeId(String empId) {
        return employeeOtherDeductionRepository.findOtherDeductionTypeByEmployeeId(empId);
    }
}
