package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

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
    private double salaryArrears;
    private double salaryRate;
    private double grossPayYearToDate;
    private double napsaYearToDate;
    private double taxableGross;
    private double pensionYearToDate;
    private double taxDue;
    private double taxCredit ;
    private double taxPaidYearToDate;

    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    private Date lastModified;
}
