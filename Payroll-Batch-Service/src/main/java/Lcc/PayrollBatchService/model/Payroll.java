package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

@Entity

public class Payroll {
    @EmbeddedId
    private PayrollCompositeKey key;

    public Payroll() {
    }

    public Payroll(PayrollCompositeKey key, double basicSalary, double housingAllowance, double educationAllowance, double transportAllowance, double fuelAllowance, double riskAllowance, double totalDeductions, double netPay, double grossPay, double salaryArrears, double salaryRate, double grossPayYearToDate, double napsaYearToDate, double taxableGross, double pensionYearToDate, double taxDue, double taxCredit, double taxPaidYearToDate, Date lastModified) {
        this.key = key;
        this.basicSalary = basicSalary;
        this.housingAllowance = housingAllowance;
        this.educationAllowance = educationAllowance;
        this.transportAllowance = transportAllowance;
        this.fuelAllowance = fuelAllowance;
        this.riskAllowance = riskAllowance;
        this.totalDeductions = totalDeductions;
        this.netPay = netPay;
        this.grossPay = grossPay;
        this.salaryArrears = salaryArrears;
        this.salaryRate = salaryRate;
        this.grossPayYearToDate = grossPayYearToDate;
        this.napsaYearToDate = napsaYearToDate;
        this.taxableGross = taxableGross;
        this.pensionYearToDate = pensionYearToDate;
        this.taxDue = taxDue;
        this.taxCredit = taxCredit;
        this.taxPaidYearToDate = taxPaidYearToDate;
        this.lastModified = lastModified;
    }

    public PayrollCompositeKey getKey() {
        return key;
    }

    public void setKey(PayrollCompositeKey key) {
        this.key = key;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getHousingAllowance() {
        return housingAllowance;
    }

    public void setHousingAllowance(double housingAllowance) {
        this.housingAllowance = housingAllowance;
    }

    public double getEducationAllowance() {
        return educationAllowance;
    }

    public void setEducationAllowance(double educationAllowance) {
        this.educationAllowance = educationAllowance;
    }

    public double getTransportAllowance() {
        return transportAllowance;
    }

    public void setTransportAllowance(double transportAllowance) {
        this.transportAllowance = transportAllowance;
    }

    public double getFuelAllowance() {
        return fuelAllowance;
    }

    public void setFuelAllowance(double fuelAllowance) {
        this.fuelAllowance = fuelAllowance;
    }

    public double getRiskAllowance() {
        return riskAllowance;
    }

    public void setRiskAllowance(double riskAllowance) {
        this.riskAllowance = riskAllowance;
    }

    public double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getSalaryArrears() {
        return salaryArrears;
    }

    public void setSalaryArrears(double salaryArrears) {
        this.salaryArrears = salaryArrears;
    }

    public double getSalaryRate() {
        return salaryRate;
    }

    public void setSalaryRate(double salaryRate) {
        this.salaryRate = salaryRate;
    }

    public double getGrossPayYearToDate() {
        return grossPayYearToDate;
    }

    public void setGrossPayYearToDate(double grossPayYearToDate) {
        this.grossPayYearToDate = grossPayYearToDate;
    }

    public double getNapsaYearToDate() {
        return napsaYearToDate;
    }

    public void setNapsaYearToDate(double napsaYearToDate) {
        this.napsaYearToDate = napsaYearToDate;
    }

    public double getTaxableGross() {
        return taxableGross;
    }

    public void setTaxableGross(double taxableGross) {
        this.taxableGross = taxableGross;
    }

    public double getPensionYearToDate() {
        return pensionYearToDate;
    }

    public void setPensionYearToDate(double pensionYearToDate) {
        this.pensionYearToDate = pensionYearToDate;
    }

    public double getTaxDue() {
        return taxDue;
    }

    public void setTaxDue(double taxDue) {
        this.taxDue = taxDue;
    }

    public double getTaxCredit() {
        return taxCredit;
    }

    public void setTaxCredit(double taxCredit) {
        this.taxCredit = taxCredit;
    }

    public double getTaxPaidYearToDate() {
        return taxPaidYearToDate;
    }

    public void setTaxPaidYearToDate(double taxPaidYearToDate) {
        this.taxPaidYearToDate = taxPaidYearToDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    private double basicSalary;
    private double housingAllowance;
    private double educationAllowance;
    private double transportAllowance;
    private double fuelAllowance;
    private double riskAllowance;
    private double totalDeductions;
    private double netPay;
    private double grossPay;
    private double salaryArrears;
    private double salaryRate;
    private double grossPayYearToDate;
    private double napsaYearToDate;
    private double taxableGross;
    private double pensionYearToDate;
    private double taxDue;
    private double taxCredit ;
    private double taxPaidYearToDate;

    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    private Date lastModified;
}
