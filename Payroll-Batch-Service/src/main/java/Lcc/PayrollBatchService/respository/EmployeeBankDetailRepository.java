package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.EmployeeBankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeBankDetailRepository extends JpaRepository<EmployeeBankDetails,String> {

    @Query("select b from EmployeeBankDetails b where b.employeeNumber =:employeeId")
    EmployeeBankDetails findBankDetailsByEmployeeNumber(String employeeId);
}
