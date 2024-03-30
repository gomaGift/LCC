package Lcc.PayrollBatchService.service;

import java.util.Collection;
import java.util.List;

public interface EmployeeOtherDeductionService {
    List<String> findOtherDeductionByEmployeeId(String empId);
}
