package Lcc.PayrollBatchService.model;

import jakarta.persistence.Embeddable;


import java.io.Serializable;
import java.util.Objects;


@Embeddable

public class PayrollCompositeKey implements Serializable {

    public PayrollCompositeKey(String employeeId, String paymentDate) {
        this.employeeId = employeeId;
        this.paymentDate = paymentDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    private String employeeId;

    public PayrollCompositeKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayrollCompositeKey that = (PayrollCompositeKey) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(paymentDate, that.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, paymentDate);
    }

    private String paymentDate;

}
