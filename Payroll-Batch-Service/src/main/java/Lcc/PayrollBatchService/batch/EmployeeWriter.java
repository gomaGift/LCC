package Lcc.PayrollBatchService.batch;

import Lcc.PayrollBatchService.dto.PaySlipEmployeeData;
import Lcc.PayrollBatchService.model.*;
import Lcc.PayrollBatchService.payrollGenerator.PayrollPdfGenerator;
import Lcc.PayrollBatchService.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeWriter implements ItemWriter<Payroll> {


   private final PayrollService payrollService;

    @Override
    public void write(Chunk<? extends Payroll> chunk) throws Exception {
         payrollService.saveAll(chunk);
    }
}
