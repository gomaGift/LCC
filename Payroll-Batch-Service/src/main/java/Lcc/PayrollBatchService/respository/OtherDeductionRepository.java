package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.OtherDeduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherDeductionRepository extends JpaRepository<OtherDeduction, String> {
   @Query("select o.deductionPercentage from OtherDeduction o where o.deductionType = :deduction")
    double findPercentageDeductionByDeductionType(String deduction);
}
