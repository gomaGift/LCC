package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.EmpOtherDeductionsCompositeKey;
import Lcc.PayrollBatchService.model.EmployeeOtherDeduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeOtherDeductionRepository extends JpaRepository<EmployeeOtherDeduction, EmpOtherDeductionsCompositeKey> {
   @Query("select e.otherDeduction.deductionType from EmployeeOtherDeduction e where e.employee.employeeId = :empId")
    List<String> findOtherDeductionTypeByEmployeeId(String empId);
}
