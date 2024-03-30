package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.model.Payroll;
import Lcc.PayrollBatchService.respository.PayrollRepository;
import Lcc.PayrollBatchService.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayrollServiceImpl implements PayrollService {

    private final PayrollRepository payrollRepository;

    @Override
    public void save(Payroll payroll) {
        payrollRepository.save(payroll);
    }
}
