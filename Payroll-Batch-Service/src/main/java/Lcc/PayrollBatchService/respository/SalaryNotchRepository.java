package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.SalaryNotch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryNotchRepository extends JpaRepository<SalaryNotch,String> {

    @Query("select s.basicSalary from SalaryNotch  s where  s.salaryScale =:salaryScale")
    double findBasicSalaryBySalaryScale(String salaryScale);
}
