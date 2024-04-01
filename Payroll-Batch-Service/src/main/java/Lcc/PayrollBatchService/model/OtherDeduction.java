package Lcc.PayrollBatchService.model;


import jakarta.persistence.*;

@Entity
public class OtherDeduction {
    @Id
    private String deductionType;
    private double deductionPercentage;
    public String getDeductionType() {
        return deductionType;
    }

    public void setDeductionType(String deductionType) {
        this.deductionType = deductionType;
    }

    public double getDeductionPercentage() {
        return deductionPercentage;
    }

    public void setDeductionPercentage(double deductionPercentage) {
        this.deductionPercentage = deductionPercentage;
    }


}
