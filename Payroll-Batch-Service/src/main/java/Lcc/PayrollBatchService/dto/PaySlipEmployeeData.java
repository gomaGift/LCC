package Lcc.PayrollBatchService.dto;

import java.time.LocalDate;


public class PaySlipEmployeeData {
    public PaySlipEmployeeData() {
    }

    public PaySlipEmployeeData(String employeeNumber, String name, String nrcNumber, String socialSecurityNumber, LocalDate dateEngaged, String employeeType, String jobGrade, String jobTitle, String branch,
                               String department, String section, String bankName, String bankAccountNumber, String payPoint, String email) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.nrcNumber = nrcNumber;
        this.socialSecurityNumber = socialSecurityNumber;
        this.dateEngaged = dateEngaged;
        this.employeeType = employeeType;
        this.jobGrade = jobGrade;
        this.jobTitle = jobTitle;
        this.branch = branch;
        this.department = department;
        this.section = section;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.payPoint = payPoint;
        this.email = email;
    }

    private String employeeNumber;
    private String name;
    private String nrcNumber;
    private String socialSecurityNumber;
    private LocalDate dateEngaged;
    private String employeeType;
    private String jobGrade;
    private String jobTitle;
    private String branch;
    private String department;
    private String section;
    private String bankName;
    private String bankAccountNumber;
    private String payPoint;
    private String email;



    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNrcNumber() {
        return nrcNumber;
    }

    public void setNrcNumber(String nrcNumber) {
        this.nrcNumber = nrcNumber;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public LocalDate getDateEngaged() {
        return dateEngaged;
    }

    public void setDateEngaged(LocalDate dateEngaged) {
        this.dateEngaged = dateEngaged;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        employeeType = employeeType;
    }

    public String getJobGrade() {
        return jobGrade;
    }

    public void setJobGrade(String jobGrade) {
        this.jobGrade = jobGrade;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getPayPoint() {
        return payPoint;
    }

    public void setPayPoint(String payPoint) {
        this.payPoint = payPoint;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
