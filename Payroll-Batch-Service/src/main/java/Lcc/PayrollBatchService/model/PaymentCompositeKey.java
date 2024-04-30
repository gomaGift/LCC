package Lcc.PayrollBatchService.model;

import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class PaymentCompositeKey implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentCompositeKey that = (PaymentCompositeKey) o;
        return Objects.equals(employeeNumber, that.employeeNumber) && Objects.equals(paymentDate, that.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, paymentDate);
    }

    public PaymentCompositeKey() {
    }

    public PaymentCompositeKey(String employeeNumber, LocalDate paymentDate) {
        this.employeeNumber = employeeNumber;
        this.paymentDate = paymentDate;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    private String employeeNumber;
    private LocalDate paymentDate;

}
