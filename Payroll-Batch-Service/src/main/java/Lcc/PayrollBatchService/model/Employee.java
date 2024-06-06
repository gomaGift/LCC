package Lcc.PayrollBatchService.model;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "employee_details")

public class Employee {
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLocalAuthority() {
        return localAuthority;
    }

    public void setLocalAuthority(String localAuthority) {
        this.localAuthority = localAuthority;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubstitutePosition() {
        return substitutePosition;
    }

    public void setSubstitutePosition(String substitutePosition) {
        this.substitutePosition = substitutePosition;
    }

    public LocalDate getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(LocalDate dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public LocalDate getDateOfConfirmation() {
        return dateOfConfirmation;
    }

    public void setDateOfConfirmation(LocalDate dateOfConfirmation) {
        this.dateOfConfirmation = dateOfConfirmation;
    }

    public LocalDate getDateAppointedToCurrentPosition() {
        return dateAppointedToCurrentPosition;
    }

    public void setDateAppointedToCurrentPosition(LocalDate dateAppointedToCurrentPosition) {
        this.dateAppointedToCurrentPosition = dateAppointedToCurrentPosition;
    }

    public String getActingWithAViewPosition() {
        return actingWithAViewPosition;
    }

    public void setActingWithAViewPosition(String actingWithAViewPosition) {
        this.actingWithAViewPosition = actingWithAViewPosition;
    }

    public LocalDate getLastAppraisalDate() {
        return lastAppraisalDate;
    }

    public void setLastAppraisalDate(LocalDate lastAppraisalDate) {
        this.lastAppraisalDate = lastAppraisalDate;
    }

    public String getAppraisalStatus() {
        return appraisalStatus;
    }

    public void setAppraisalStatus(String appraisalStatus) {
        this.appraisalStatus = appraisalStatus;
    }

    public LocalDate getDateOfContractEnd() {
        return dateOfContractEnd;
    }

    public void setDateOfContractEnd(LocalDate dateOfContractEnd) {
        this.dateOfContractEnd = dateOfContractEnd;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getThirdParties() {
        return thirdParties;
    }

    public void setThirdParties(String thirdParties) {
        this.thirdParties = thirdParties;
    }

    @Id
    private String employeeId;

    private String position;

    private String province;
    private String localAuthority;
    private String section;
    private String substitutePosition;
    private LocalDate dateOfAppointment;
    private LocalDate  dateOfConfirmation;
    private LocalDate  dateAppointedToCurrentPosition;
    private String  actingWithAViewPosition;
    private LocalDate  lastAppraisalDate;
    private String appraisalStatus;
    private LocalDate dateOfContractEnd;
    private String  employmentType;
    private String employmentStatus;
    private String thirdParties;
   
}
