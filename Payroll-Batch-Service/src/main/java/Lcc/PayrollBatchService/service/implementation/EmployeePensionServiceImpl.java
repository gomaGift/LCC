package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.respository.EmployeePensionRepository;
import Lcc.PayrollBatchService.service.EmployeePensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeePensionServiceImpl implements EmployeePensionService {

    @Autowired
    private EmployeePensionRepository employeePensionRepository;;
    @Override
    public String findPensionTypeByEmployeeId(String empId) {
        return employeePensionRepository.findPensionTypeByEmployeeId(empId);
    }

    @Override
    public double findEmployeePercentageByPensionType(String pensionType) {
        return employeePensionRepository.findEmployeePercentageByPensionType(pensionType);
    }
}
