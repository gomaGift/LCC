package Lcc.PayrollBatchService.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class EmployeeInsuranceCompositeKey implements Serializable {

     private String employeeId;
     private String insuranceType;

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          EmployeeInsuranceCompositeKey that = (EmployeeInsuranceCompositeKey) o;
          return Objects.equals(employeeId, that.employeeId) && Objects.equals(insuranceType, that.insuranceType);
     }

     @Override
     public int hashCode() {
          return Objects.hash(employeeId, insuranceType);
     }
}
