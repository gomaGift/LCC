package Lcc.PayrollBatchService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import java.time.LocalDate;

@Entity
public class EmployeeOnPayroll {

    public EmployeeOnPayroll() {
    }

    public EmployeeOnPayroll(String employeeId, LocalDate dateStarted, LocalDate dateEnd, boolean active) {
        this.employeeId = employeeId;
        this.dateStarted = dateStarted;
        this.dateEnd = dateEnd;
        this.active = active;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

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
