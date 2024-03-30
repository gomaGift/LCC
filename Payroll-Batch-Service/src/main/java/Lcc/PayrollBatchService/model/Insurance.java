package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;


import java.util.*;

@Entity

public class Insurance {
    @Id
    private String insuranceType;
    private double percentageContribution;
    public Insurance(){}
    public Insurance(String insuranceType, double percentageContribution ){
        this.insuranceType = insuranceType;
        this.percentageContribution= percentageContribution;
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
}
