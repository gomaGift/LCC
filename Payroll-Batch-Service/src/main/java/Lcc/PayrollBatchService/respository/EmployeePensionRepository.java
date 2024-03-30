package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.EmployeePension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePensionRepository extends JpaRepository<EmployeePension, String> {
    @Query("select p.pension.pensionType from EmployeePension p where p.employeeId = :empId")
    String findPensionTypeByEmployeeId(String empId);

    @Query("select p.pension.employeePercentage from EmployeePension p where p.pension.pensionType = :pensionType")
    double findEmployeePercentageByPensionType(String pensionType);
}
