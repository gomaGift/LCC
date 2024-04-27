package Lcc.PayrollBatchService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryNotch {
    @Id
    private String salaryScale;
    private double basicSalary;
    private LocalDate dateStarted;
    private LocalDate dateTo;
    private String salaryNotch;
}
