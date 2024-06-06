package Lcc.PayrollBatchService.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Payment {

    public PaymentCompositeKey getKey() {
        return key;
    }

    public void setKey(PaymentCompositeKey key) {
        this.key = key;
    }

    public Payment(PaymentCompositeKey key, double amount, String reference) {
        this.key = key;
        this.amount = amount;
        this.reference = reference;
    }

    public Payment() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @EmbeddedId
    private PaymentCompositeKey key;
    private double amount;
    private String reference;
}
