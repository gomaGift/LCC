package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.model.Payroll;
import Lcc.PayrollBatchService.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeWriter implements ItemWriter<Payroll> {


   private final PayrollService payrollService;
    @Override
    public void write(Chunk<? extends Payroll> chunk) throws Exception {
        payrollService.saveAll(chunk);
    }
}
