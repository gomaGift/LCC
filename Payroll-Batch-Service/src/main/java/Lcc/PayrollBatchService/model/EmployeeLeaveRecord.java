package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name="leaveRecords")
public class EmployeeLeaveRecord {

    @Id
    private Integer id;

    private double leaveRate = 2;
    private LocalDate startDate;
    private LocalDate endDate;

    public EmployeeLeaveRecord(Integer id, double leaveRate, LocalDate startDate, LocalDate endDate, LeaveType leaveType, LeaveStatus leaveStatus, Employee employee) {
        this.id = id;
        this.leaveRate = leaveRate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.leaveStatus = leaveStatus;
        this.employee = employee;
    }

    public EmployeeLeaveRecord() {
    }

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;
    @Enumerated(EnumType.STRING)
    private LeaveStatus leaveStatus;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getLeaveRate() {
        return leaveRate;
    }

    public void setLeaveRate(double leaveRate) {
        this.leaveRate = leaveRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public LeaveStatus getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(LeaveStatus leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
