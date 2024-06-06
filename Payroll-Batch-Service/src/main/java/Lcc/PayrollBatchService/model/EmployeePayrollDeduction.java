package Lcc.PayrollBatchService.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
public class EmployeePayrollDeduction {

    public EmployeePayrollDeduction() {
    }

    @EmbeddedId
    private EmpDeductionCompositeKey key;
    private double percentageDeduction ;
    private double amount;

    public EmpDeductionCompositeKey getKey() {
        return key;
    }

    public void setKey(EmpDeductionCompositeKey key) {
        this.key = key;
    }

    public double getPercentageDeduction() {
        return percentageDeduction;
    }

    public void setPercentageDeduction(double percentageDeduction) {
        this.percentageDeduction = percentageDeduction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    private Date lastModified;

    public EmployeePayrollDeduction(EmpDeductionCompositeKey key, double percentageDeduction, double amount){
        this.key = key;
        this.percentageDeduction = percentageDeduction;
        this.amount = amount;
    }

}
