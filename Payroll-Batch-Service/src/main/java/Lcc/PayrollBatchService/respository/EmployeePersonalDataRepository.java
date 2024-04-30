package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.EmployeePersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePersonalDataRepository extends JpaRepository<EmployeePersonalData, String> {

    @Query("select e from EmployeePersonalData e where e.employeeNumber =:employeeId")
    EmployeePersonalData findEmployeeDataByEmployeeNumber(String employeeId);
}
