package Lcc.PayrollBatchService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeePersonalData {
    public EmployeePersonalData() {
    }

    public EmployeePersonalData(String employeeNumber, String formerFileNumber, String title, String nrc, String socialSecurityNumber, String surname, String firstname, String middleName, String sex, String staffPhoto, String maritalStatus, String maidenName, String physicalChallenge, String postalAddress, String townOrVillage) {
        this.employeeNumber = employeeNumber;
        this.formerFileNumber = formerFileNumber;
        this.title = title;
        this.nrc = nrc;
        this.socialSecurityNumber = socialSecurityNumber;
        this.surname = surname;
        this.firstname = firstname;
        this.middleName = middleName;
        this.sex = sex;
        this.staffPhoto = staffPhoto;
        this.maritalStatus = maritalStatus;
        this.maidenName = maidenName;
        this.physicalChallenge = physicalChallenge;
        this.postalAddress = postalAddress;
        this.townOrVillage = townOrVillage;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFormerFileNumber() {
        return formerFileNumber;
    }

    public void setFormerFileNumber(String formerFileNumber) {
        this.formerFileNumber = formerFileNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStaffPhoto() {
        return staffPhoto;
    }

    public void setStaffPhoto(String staffPhoto) {
        this.staffPhoto = staffPhoto;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getPhysicalChallenge() {
        return physicalChallenge;
    }

    public void setPhysicalChallenge(String physicalChallenge) {
        this.physicalChallenge = physicalChallenge;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getTownOrVillage() {
        return townOrVillage;
    }

    public void setTownOrVillage(String townOrVillage) {
        this.townOrVillage = townOrVillage;
    }

    @Id
    private String employeeNumber;
    private String formerFileNumber;
    private String title;
    private String nrc;
    private String socialSecurityNumber;
    private String surname;
    private String firstname;
    private String middleName;
    private String sex;
    private String staffPhoto;
    private String maritalStatus;
    private String maidenName;
    private String physicalChallenge;
    private String postalAddress;
    private String townOrVillage;

}
