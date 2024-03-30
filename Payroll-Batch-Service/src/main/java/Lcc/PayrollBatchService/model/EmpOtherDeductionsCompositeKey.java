package Lcc.PayrollBatchService.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OtherDeductionsCompositeKey implements Serializable {

    private String employeeId;
    private String otherDeductionsType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OtherDeductionsCompositeKey that = (OtherDeductionsCompositeKey) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(otherDeductionsType, that.otherDeductionsType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, otherDeductionsType);
    }
}
