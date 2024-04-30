package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.model.EmployeePersonalData;
import Lcc.PayrollBatchService.respository.EmployeePersonalDataRepository;
import Lcc.PayrollBatchService.service.EmployeePersonalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeePersonalDataImpl implements EmployeePersonalDataService {

    @Autowired
    private EmployeePersonalDataRepository employeePersonalDataRepository;

    @Override
    public EmployeePersonalData findEmployeeDataByEmployeeNumber(String employeeId) {
        return employeePersonalDataRepository.findEmployeeDataByEmployeeNumber(employeeId);
    }
}
