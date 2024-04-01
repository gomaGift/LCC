package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class EmployeeInsurance {

    @EmbeddedId
    private EmpInsuranceCompositeKey id;
    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @MapsId("insuranceType")
    @JoinColumn(name = "insurance_type")
    private Insurance insurance;

    private LocalDate dateStarted = LocalDate.now();
    private LocalDate dateEnd;

}
