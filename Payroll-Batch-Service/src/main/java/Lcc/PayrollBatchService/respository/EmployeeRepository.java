package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("select e.position from Employee e where e.employeeId = :empId")
    String findPositionByEmployeeId(String empId);
}
