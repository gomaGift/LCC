package Lcc.PayrollBatchService.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmpInsuranceCompositeKey implements Serializable {
     private String employeeId;
     private String insuranceType;

     public EmpInsuranceCompositeKey(String employeeId, String insuranceType) {
          this.employeeId = employeeId;
          this.insuranceType = insuranceType;
     }

     public EmpInsuranceCompositeKey() {
     }

     public String getEmployeeId() {
          return employeeId;
     }

     public void setEmployeeId(String employeeId) {
          this.employeeId = employeeId;
     }

     public String getInsuranceType() {
          return insuranceType;
     }

     public void setInsuranceType(String insuranceType) {
          this.insuranceType = insuranceType;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          EmpInsuranceCompositeKey that = (EmpInsuranceCompositeKey) o;
          return Objects.equals(employeeId, that.employeeId) && Objects.equals(insuranceType, that.insuranceType);
     }

     @Override
     public int hashCode() {
          return Objects.hash(employeeId, insuranceType);
     }
}
