package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.EmployeeInsurance;
import Lcc.PayrollBatchService.model.EmpInsuranceCompositeKey;
import Lcc.PayrollBatchService.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeInsuranceRepository extends JpaRepository<EmployeeInsurance, EmpInsuranceCompositeKey> {
    @Query("SELECT e.insurance.insuranceType FROM EmployeeInsurance e WHERE e.employee.employeeId = :empId")
    List<String> findInsuranceTypeByEmployeeId(String empId);
}
