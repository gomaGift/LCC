package Lcc.PayrollBatchService.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor

public class EmployeePayrollDeduction {
    
    @EmbeddedId
    private EmpDeductionCompositeKey key;
    private double percentageDeduction ;
    private double amount;

    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    private Date lastModified;

    public EmployeePayrollDeduction(EmpDeductionCompositeKey key, double percentageDeduction, double amount){
        this.key = key;
        this.percentageDeduction = percentageDeduction;
        this.amount = amount;
    }

}
