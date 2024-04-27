package Lcc.PayrollBatchService.service;

public interface PositionService {
   String findSalaryScaleByPosition(String position);

    double findHousingAllowanceByPosition(String position);

    double findFuelAllowanceByPosition(String position);

    double findRiskAllowanceByPosition(String position);

    double findTransportAllowanceByPosition(String position);

    double findEducationalAllowanceByPosition(String position);
}
