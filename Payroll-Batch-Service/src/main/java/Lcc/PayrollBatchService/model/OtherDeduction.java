package Lcc.PayrollBatchService.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OtherDeduction {

    @Id
    private String deductionType;
    private double deductionPercentage;

}
