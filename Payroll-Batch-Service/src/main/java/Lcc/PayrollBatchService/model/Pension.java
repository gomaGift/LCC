package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;




@Entity

public class Pension {
    public Pension() {
    }

    public Pension(String pensionType, double employeePercentage, double employerPercentage) {
        this.pensionType = pensionType;
        this.employeePercentage = employeePercentage;
        this.employerPercentage = employerPercentage;
    }

    @Id
    private String pensionType;

    public String getPensionType() {
        return pensionType;
    }

    public void setPensionType(String pensionType) {
        this.pensionType = pensionType;
    }

    public double getEmployeePercentage() {
        return employeePercentage;
    }

    public void setEmployeePercentage(double employeePercentage) {
        this.employeePercentage = employeePercentage;
    }

    public double getEmployerPercentage() {
        return employerPercentage;
    }

    public void setEmployerPercentage(double employerPercentage) {
        this.employerPercentage = employerPercentage;
    }

    private double employeePercentage;
    private double employerPercentage;

}
