package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
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

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public EmpInsuranceCompositeKey getId() {
        return id;
    }

    public void setId(EmpInsuranceCompositeKey id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}
