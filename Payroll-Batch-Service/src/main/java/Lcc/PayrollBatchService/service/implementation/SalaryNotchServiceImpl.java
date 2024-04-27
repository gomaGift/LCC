package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.respository.SalaryNotchRepository;
import Lcc.PayrollBatchService.service.SalaryNotchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class SalaryNotchServiceImpl implements SalaryNotchService {
    @Autowired
    private SalaryNotchRepository salaryNotchRepository;
    @Override
    public double findBasicSalaryBySalaryScale(String salaryScale) {
        return salaryNotchRepository.findBasicSalaryBySalaryScale(salaryScale);
    }
}
