package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.EmployeeOnPayroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesOnPayrollRepository extends JpaRepository<EmployeeOnPayroll, String> {
}
