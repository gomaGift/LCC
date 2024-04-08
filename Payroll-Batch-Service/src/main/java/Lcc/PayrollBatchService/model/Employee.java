package Lcc.PayrollBatchService.model;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "employees")
@Data
public class Employee {
    
    @Id
    private String employeeId;
    @ManyToOne
    @JoinColumn(name = "position")
    private Position position;
   
}
