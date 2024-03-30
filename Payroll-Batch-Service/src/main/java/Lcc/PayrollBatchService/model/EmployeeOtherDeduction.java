package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class EmployeeOtherDeduction {

    @EmbeddedId
    private EmpOtherDeductionsCompositeKey id;
    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @MapsId("otherDeductionsType")
    @JoinColumn(name = "deduction_type")
    private OtherDeduction otherDeduction;

    private String dateStarted;

    private String dateEnd;
}
