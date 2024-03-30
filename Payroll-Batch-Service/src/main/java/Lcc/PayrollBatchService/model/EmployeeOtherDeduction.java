package Lcc.PayrollBatchService.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

import java.time.LocalDate;

public class EmployeeOtherDeductions {

    @EmbeddedId
    private OtherDeductionsCompositeKey id;
    @ManyToOne
    @MapsId("employeeId")
    private Employee employee;

    @ManyToOne
    @MapsId("otherDeductionsType")
    private OtherDeduction otherDeduction;

    private LocalDate dateStarted = LocalDate.now();

    private LocalDate dateEnd;

}
