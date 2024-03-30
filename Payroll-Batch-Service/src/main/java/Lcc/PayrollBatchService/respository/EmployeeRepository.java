package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.Employee;
import Lcc.PayrollBatchService.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("select e.position from Employee e where e.employeeId = :empId")
    Position findPositionByEmployeeId(String empId);
}
