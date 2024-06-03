package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

    @Query("select p.salaryScale from Position p where p.position = :position")
    String findSalaryScaleByPosition(String position);

    @Query("select p.housingAllowance from Position p where p.position = :position")
    double findHousingAllowanceByPosition(String position);

    @Query("select p.fuelAllowance from Position p where p.position = :position")
    double findFuelAllowanceByPosition(String position);
    @Query("select p.riskAllowance from Position p where p.position = :position")
    double findRiskAllowanceByPosition(String position);
    @Query("select p.transportAllowance from Position p where p.position = :position")
    double findTransportAllowanceByPosition(String position);
    @Query("select p.educationAllowance from Position p where p.position = :position")
    double findEducationalByPosition(String position);

    @Query("select p from Position p where p.position = :employeePosition")
    Position findPositionByEmployeePosition(String employeePosition);
}
