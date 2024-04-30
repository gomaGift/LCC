package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.PayAsYouEarnCompositeKey;
import Lcc.PayrollBatchService.model.PayAsYouEarnTaxBand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayAsYouEarnTaxBandRepository extends JpaRepository<PayAsYouEarnTaxBand, PayAsYouEarnCompositeKey> {
}
