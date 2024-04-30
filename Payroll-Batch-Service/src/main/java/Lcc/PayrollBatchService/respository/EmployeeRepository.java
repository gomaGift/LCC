package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("select e.position from Employee e where e.employeeId = :empId")
    String findPositionByEmployeeId(String empId);

    @Query("select e.dateOfAppointment from Employee e where e.employeeId =:employeeId")
    LocalDate findDateEmployeeDateOfFirstEngagementByEmpId(String employeeId);

    @Query("select e from Employee e where e.employeeId=:employeeId")
    Employee findByEmployeeByEmployeeId(String employeeId);
}
