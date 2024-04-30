package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.model.EmployeeBankDetails;
import Lcc.PayrollBatchService.respository.EmployeeBankDetailRepository;
import Lcc.PayrollBatchService.service.EmployeeBankDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeBankDetailServiceImpl implements EmployeeBankDetailService {

    @Autowired
    private EmployeeBankDetailRepository employeeBankDetailRepository;

    @Override
    public EmployeeBankDetails findEmployeeBankDetailByEmployeeNumber(String employeeId) {
        return employeeBankDetailRepository.findBankDetailsByEmployeeNumber(employeeId);
    }
}
