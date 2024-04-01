package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    @Id
    private String insuranceType;
    private double percentageContribution;
   

}
