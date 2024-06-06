package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
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

    public EmployeePension() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
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
}
