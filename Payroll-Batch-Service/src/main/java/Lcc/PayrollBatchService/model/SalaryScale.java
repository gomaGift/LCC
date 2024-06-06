package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;


import java.time.LocalDate;


@Entity

@Table(name = "salary_scales")
public class SalaryScale {
    public SalaryScale() {
    }

    public String getSalaryScale() {
        return salaryScale;
    }

    public void setSalaryScale(String salaryScale) {
        this.salaryScale = salaryScale;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SalaryScale(String salaryScale, String division, String description) {
        this.salaryScale = salaryScale;
        this.division = division;
        this.description = description;
    }

    @Id
    private String salaryScale;
    private String division;
    private String description;
}
