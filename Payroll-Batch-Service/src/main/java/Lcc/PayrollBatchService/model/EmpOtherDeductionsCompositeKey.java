package Lcc.PayrollBatchService.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmpOtherDeductionsCompositeKey implements Serializable {

    private String employeeId;
    private String otherDeductionsType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpOtherDeductionsCompositeKey that = (EmpOtherDeductionsCompositeKey) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(otherDeductionsType, that.otherDeductionsType);
    }

    public EmpOtherDeductionsCompositeKey() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, otherDeductionsType);
    }

    public EmpOtherDeductionsCompositeKey(String employeeId, String otherDeductionsType) {
        this.employeeId = employeeId;
        this.otherDeductionsType = otherDeductionsType;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getOtherDeductionsType() {
        return otherDeductionsType;
    }

    public void setOtherDeductionsType(String otherDeductionsType) {
        this.otherDeductionsType = otherDeductionsType;
    }
}
