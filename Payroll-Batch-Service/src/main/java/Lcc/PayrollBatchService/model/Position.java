package Lcc.PayrollBatchService.model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class Position {
    @Id
    private String position;
    private String department;
    private BigDecimal housingAllowance;
    private BigDecimal educationAllowance;
    private BigDecimal transportAllowance;
    private BigDecimal fuelAllowance;
    private BigDecimal riskAllowance;
    @ManyToOne
    @JoinColumn(name = "salary_scale")
    private Salary_Scale salaryScale;

}
