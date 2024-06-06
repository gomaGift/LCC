package Lcc.PayrollBatchService.model;
import jakarta.persistence.*;

@Entity
@Table(name = "positions")
public class Position {

    public Position() {
    }
    public Position(int departmentId, String position, String salaryScale, double housingAllowance, double educationAllowance, double transportAllowance, double fuelAllowance, double riskAllowance) {
        this.departmentId = departmentId;
        this.position = position;
        this.salaryScale = salaryScale;
        this.housingAllowance = housingAllowance;
        this.educationAllowance = educationAllowance;
        this.transportAllowance = transportAllowance;
        this.fuelAllowance = fuelAllowance;
        this.riskAllowance = riskAllowance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;
    private int departmentId;
    private String position;
    private String salaryScale;
    private double housingAllowance;
    private double educationAllowance;
    private double transportAllowance;
    private double fuelAllowance;
    private double riskAllowance;

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalaryScale() {
        return salaryScale;
    }

    public void setSalaryScale(String salaryScale) {
        this.salaryScale = salaryScale;
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
}
