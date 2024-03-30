package Lcc.PayrollBatchService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class EmployeePension {
    @Id
    private String employeeId;

    @OneToOne
    @JoinColumn(name = "pensionType")
    private Pension pension;
    private LocalDate dateStarted;
    private LocalDate dateEnd;

    public EmployeePension(String employeeId, Pension pension){
        this.employeeId = employeeId;
        this.pension = pension;
        dateStarted = LocalDate.now();
    }

}
