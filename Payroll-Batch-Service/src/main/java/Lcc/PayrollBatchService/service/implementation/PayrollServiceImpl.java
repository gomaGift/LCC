package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.model.Payroll;
import Lcc.PayrollBatchService.respository.PayrollRepository;
import Lcc.PayrollBatchService.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PayrollServiceImpl implements PayrollService {

    private final PayrollRepository payrollRepository;

    @Override
    public void save(Payroll payroll) {
        payrollRepository.save(payroll);
    }

    @Override
    public Chunk<? extends Payroll> saveAll(Chunk<? extends Payroll> chunk) {
        payrollRepository.saveAll(chunk);
        return chunk;
    }

    @Override
    public List<Payroll> findPayrollRecordsByDate(String payrollDate) {
        return payrollRepository.findRecordsByDate(payrollDate);
    }




    @Override
    public double findYtdGrossSalary(String empId, Date startDate) {
       return payrollRepository.findYtdGrossSalary(empId, startDate);
    }

    @Override
    public double findTaxPaidYearToDate(String empId, Date startDate) {
        return payrollRepository.findTaxPaidYearToDate(empId, startDate);
    }


}
