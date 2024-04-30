package Lcc.PayrollBatchService.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class LeaveRecordCompositeKey implements Serializable {
    private String employeeId;

    public LeaveRecordCompositeKey(String employeeId, LocalDate dateStart, LocalDate dateEnd) {
        this.employeeId = employeeId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }
    public LeaveRecordCompositeKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaveRecordCompositeKey that = (LeaveRecordCompositeKey) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(dateStart, that.dateStart) && Objects.equals(dateEnd, that.dateEnd);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, dateStart, dateEnd);
    }

    private LocalDate dateStart;
    private LocalDate dateEnd;

}
