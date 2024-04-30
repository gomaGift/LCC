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

    private String pension;
    private LocalDate dateStarted;
    private LocalDate dateEnd;
    public EmployeePension(String employeeId, String pension){
        this.employeeId = employeeId;
        this.pension = pension;
        dateStarted = LocalDate.now();
    }

}
