package Lcc.PayrollBatchService.PayrollGenerator;

import Lcc.PayrollBatchService.model.Payroll;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PayrollDataMapper {

    public Context setData(List<Payroll> payrollList){
        Context context = new Context();

        Map<String, Object> stringPayrollMap = new HashMap<>();
        stringPayrollMap.put("payroll", payrollList);
        context.setVariables(stringPayrollMap);
        return context;
    }
}
