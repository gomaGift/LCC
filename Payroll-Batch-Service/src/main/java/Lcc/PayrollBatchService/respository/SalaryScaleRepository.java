package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.SalaryScale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryScaleRepository extends JpaRepository<SalaryScale, String> {
}
