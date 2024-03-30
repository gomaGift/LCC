package Lcc.PayrollBatchService.model;


import jakarta.persistence.*;


@Entity
@Table(name = "employees")
public class Employee {
    @Id
    private String employeeId;
    @OneToOne
    @JoinColumn(name = "position")
    private Position position;
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
}
