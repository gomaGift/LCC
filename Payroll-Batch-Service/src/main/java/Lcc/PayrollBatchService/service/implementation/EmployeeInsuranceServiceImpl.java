package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.model.Insurance;
import Lcc.PayrollBatchService.respository.EmployeeInsuranceRepository;
import Lcc.PayrollBatchService.service.EmployeeInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeInsuranceServiceImpl implements EmployeeInsuranceService {

    @Autowired
    private EmployeeInsuranceRepository employeeInsuranceRepository;




    @Override
    public List<String> findInsuranceTypeByEmployeeId(String empId) {
        return employeeInsuranceRepository.findInsuranceTypeByEmployeeId(empId);
    }
}
