package Lcc.PayrollBatchService.respository;


import Lcc.PayrollBatchService.model.Payment;
import Lcc.PayrollBatchService.model.PaymentCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, PaymentCompositeKey> {
}
