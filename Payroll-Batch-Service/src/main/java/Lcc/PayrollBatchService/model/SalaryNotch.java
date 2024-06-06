package Lcc.PayrollBatchService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity

public class SalaryNotch {
    public String getSalaryScale() {
        return salaryScale;
    }

    public void setSalaryScale(String salaryScale) {
        this.salaryScale = salaryScale;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getSalaryNotch() {
        return salaryNotch;
    }

    public void setSalaryNotch(String salaryNotch) {
        this.salaryNotch = salaryNotch;
    }

    @Id
    private String salaryScale;
    private double basicSalary;

    public SalaryNotch() {
    }

    public SalaryNotch(String salaryScale, double basicSalary, LocalDate dateStarted, LocalDate dateTo, String salaryNotch) {
        this.salaryScale = salaryScale;
        this.basicSalary = basicSalary;
        this.dateStarted = dateStarted;
        this.dateTo = dateTo;
        this.salaryNotch = salaryNotch;
    }

    private LocalDate dateStarted;
    private LocalDate dateTo;
    private String salaryNotch;
}
