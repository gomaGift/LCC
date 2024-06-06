package Lcc.PayrollBatchService.model;
import jakarta.persistence.*;

@Entity
public class Insurance {
    @Id
    private String insuranceType;
    private double percentageContribution;

    public Insurance() {
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public double getPercentageContribution() {
        return percentageContribution;
    }

    public void setPercentageContribution(double percentageContribution) {
        this.percentageContribution = percentageContribution;
    }

    public Insurance(String insuranceType, double percentageContribution) {
        this.insuranceType = insuranceType;
        this.percentageContribution = percentageContribution;
    }
}
