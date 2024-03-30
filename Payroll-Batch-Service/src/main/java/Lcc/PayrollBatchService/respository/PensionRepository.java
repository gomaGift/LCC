package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.Pension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PensionRepository extends JpaRepository<Pension, String> {
    @Query("select p.employeePercentage from Pension p where p.pensionType = :pensionType")
    double findEmployeePercentageByPensionType(String pensionType);
}
