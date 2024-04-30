package Lcc.PayrollBatchService.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Payment {

    @EmbeddedId
    private PaymentCompositeKey key;
    private double amount;
    private String reference;
}
