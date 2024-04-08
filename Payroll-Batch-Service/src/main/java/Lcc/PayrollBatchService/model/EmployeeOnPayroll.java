package Lcc.PayrollBatchService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class EmployeeOnPayroll {

    @Id
    private String employeeId;
    private LocalDate dateStarted;
    private LocalDate dateEnd;
    private boolean active;
    public EmployeeOnPayroll(String employeeId){
        this.employeeId = employeeId;
        dateStarted = LocalDate.now();
        active = true;
    }


}
