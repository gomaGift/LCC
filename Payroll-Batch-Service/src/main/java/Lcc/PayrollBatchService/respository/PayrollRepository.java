package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.Payroll;
import Lcc.PayrollBatchService.model.PayrollCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, PayrollCompositeKey> {
}
