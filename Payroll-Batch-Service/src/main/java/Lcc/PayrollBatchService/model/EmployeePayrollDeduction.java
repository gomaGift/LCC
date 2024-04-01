package Lcc.PayrollBatchService.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDeduction {
    @EmbeddedId
    private EmpDeductionCompositeKey key;
    private double percentageDeduction = 0;
    private double amount;


}
