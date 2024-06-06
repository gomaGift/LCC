package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;


@Entity
public class EmployeeOtherDeduction {
    @EmbeddedId
    private EmpOtherDeductionsCompositeKey id;

    public EmployeeOtherDeduction() {
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private EmployeeOnPayroll employee;

    public EmployeeOtherDeduction(EmpOtherDeductionsCompositeKey id, EmployeeOnPayroll employee, OtherDeduction otherDeduction, String dateStarted, String dateEnd) {
        this.id = id;
        this.employee = employee;
        this.otherDeduction = otherDeduction;
        this.dateStarted = dateStarted;
        this.dateEnd = dateEnd;
    }

    @ManyToOne
    @MapsId("otherDeductionsType")
    @JoinColumn(name = "deduction_type")
    private OtherDeduction otherDeduction;

    private String dateStarted;
    private String dateEnd;

    public EmpOtherDeductionsCompositeKey getId() {
        return id;
    }

    public void setId(EmpOtherDeductionsCompositeKey id) {
        this.id = id;
    }

    public EmployeeOnPayroll getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeOnPayroll employee) {
        this.employee = employee;
    }

    public OtherDeduction getOtherDeduction() {
        return otherDeduction;
    }

    public void setOtherDeduction(OtherDeduction otherDeduction) {
        this.otherDeduction = otherDeduction;
    }

    public String getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
