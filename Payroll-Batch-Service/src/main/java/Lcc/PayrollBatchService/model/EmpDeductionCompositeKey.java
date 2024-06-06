package Lcc.PayrollBatchService.model;

import jakarta.persistence.Embeddable;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmpDeductionCompositeKey implements Serializable {

    private String employeeId;
    private String deductionType;

    public EmpDeductionCompositeKey(String employeeId, String deductionType, String deductionDate) {
        this.employeeId = employeeId;
        this.deductionType = deductionType;
        this.deductionDate = deductionDate;
    }

    public String getDeductionType() {
        return deductionType;
    }

    public void setDeductionType(String deductionType) {
        this.deductionType = deductionType;
    }

    public String getDeductionDate() {
        return deductionDate;
    }

    public void setDeductionDate(String deductionDate) {
        this.deductionDate = deductionDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public EmpDeductionCompositeKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpDeductionCompositeKey that = (EmpDeductionCompositeKey) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(deductionType, that.deductionType) && Objects.equals(deductionDate, that.deductionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, deductionType, deductionDate);
    }

    private String deductionDate;

}
