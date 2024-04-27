package Lcc.PayrollBatchService.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Table(name = "employee_details")
@Data
public class Employee {
    
    @Id
    private String employeeId;

    private String position;

    private String province;
    private String localAuthority;
    private String section;
    private String substitutePosition;
    private LocalDate dateOfAppointment;
    private LocalDate  dateOfConfirmation;
    private LocalDate  dateAppointedToCurrentPosition;
    private String  actingWithAViewPosition;
    private LocalDate  lastAppraisalDate;
    private String appraisalStatus;
    private LocalDate dateOfContractEnd;
    private String  employmentType;
    private String employmentStatus;
    private String thirdParties;
   
}
