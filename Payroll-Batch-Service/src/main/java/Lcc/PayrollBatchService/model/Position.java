package Lcc.PayrollBatchService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
@Entity
@Data
public class Position {
    @Id
    private String position;
    private String department;
    private double housingAllowance;
    private double educationAllowance;
    private double transportAllowance;
    private double fuelAllowance;
    private double riskAllowance;

    @ManyToOne
    @JoinColumn(name = "salary_scale")
    private SalaryScale salaryScale;

}
