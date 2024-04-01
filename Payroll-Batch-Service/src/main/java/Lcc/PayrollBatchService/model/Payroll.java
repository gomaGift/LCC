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
public class Payroll {
    @EmbeddedId
    private PayrollCompositeKey key;

    private double basicSalary;
    private double housingAllowance;
    private double educationAllowance;
    private double transportAllowance;
    private double fuelAllowance;
    private double riskAllowance;
    private double totalDeductions;
    private double netPay;
    private double grossPay;



}
