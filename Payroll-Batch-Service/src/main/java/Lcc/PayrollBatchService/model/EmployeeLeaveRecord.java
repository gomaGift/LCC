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
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;
    @Enumerated(EnumType.STRING)
    private LeaveStatus leaveStatus;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;




}
