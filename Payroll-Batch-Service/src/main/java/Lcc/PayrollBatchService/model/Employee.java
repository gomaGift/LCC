package Lcc.PayrollBatchService.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {

    // Replace with the actual attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    private String firstname;
    private String lastname;
    private double salary;
    private String position;
    private String department;
}
