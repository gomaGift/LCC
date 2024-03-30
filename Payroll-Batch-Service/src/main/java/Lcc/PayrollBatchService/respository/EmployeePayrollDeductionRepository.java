package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.EmpDeductionCompositeKey;
import Lcc.PayrollBatchService.model.EmployeePayrollDeduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollDeductionRepository extends JpaRepository<EmployeePayrollDeduction, EmpDeductionCompositeKey> {
}
