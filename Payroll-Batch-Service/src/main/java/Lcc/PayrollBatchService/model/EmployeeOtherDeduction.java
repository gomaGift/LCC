package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EmployeeOtherDeduction {
    @EmbeddedId
    private EmpOtherDeductionsCompositeKey id;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private EmployeeOnPayroll employee;

    @ManyToOne
    @MapsId("otherDeductionsType")
    @JoinColumn(name = "deduction_type")
    private OtherDeduction otherDeduction;

    private String dateStarted;
    private String dateEnd;
}
