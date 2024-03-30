package Lcc.PayrollBatchService.service.implementation;


import Lcc.PayrollBatchService.respository.EmployeePensionRepository;
import Lcc.PayrollBatchService.respository.PensionRepository;
import Lcc.PayrollBatchService.service.PensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PensionServiceImpl implements PensionService {
    @Autowired
    private PensionRepository pensionRepository;
    @Override
    public double findEmployeePercentageByPensionType(String pensionType) {
        return pensionRepository.findEmployeePercentageByPensionType(pensionType);
    }
}
