package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class EmployeePension {
    @Id
    private String employeeId;

    @ManyToOne 
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
