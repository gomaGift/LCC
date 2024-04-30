package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.EmpDeductionCompositeKey;
import Lcc.PayrollBatchService.model.EmployeePayrollDeduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePayrollDeductionRepository extends JpaRepository<EmployeePayrollDeduction, EmpDeductionCompositeKey> {

    @Query("select ed from EmployeePayrollDeduction ed where ed.key.employeeId =:employeeId and ed.key.deductionDate =:paymentDate")
    List<EmployeePayrollDeduction> findAllByEmployeeNumberAndDate(String employeeId, String paymentDate);
}
