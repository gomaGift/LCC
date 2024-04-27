package Lcc.PayrollBatchService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeBankDetails {

    public EmployeeBankDetails() {
    }

    public EmployeeBankDetails(String employeeNumber, String bankName, String branch, String accountNumber, String sortCode) {
        this.employeeNumber = employeeNumber;
        this.bankName = bankName;
        this.branch = branch;
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    @Id
    private String employeeNumber;
    private String bankName;
    private String branch;
    private String accountNumber;
    private String sortCode;

}
