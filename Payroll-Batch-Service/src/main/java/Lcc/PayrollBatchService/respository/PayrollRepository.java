package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.Payroll;
import Lcc.PayrollBatchService.model.PayrollCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, PayrollCompositeKey> {


    @Query("SELECT p FROM Payroll p WHERE p.key.paymentDate = :payrollDate")
    List<Payroll> findRecordsByDate(String payrollDate);
}
