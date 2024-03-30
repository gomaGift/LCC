package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Collection;
import java.util.HashSet;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pension {

    @Id
    private String pensionType;
    private double employeePercentage;
    private double employerPercentage;

}
