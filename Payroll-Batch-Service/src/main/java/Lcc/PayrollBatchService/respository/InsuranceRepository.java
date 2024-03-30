package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, String> {
    @Query("SELECT e.percentageContribution FROM Insurance e WHERE e.insuranceType = :insuranceType")
    double findPercentageContributionByInsuranceType(String insuranceType);
}
