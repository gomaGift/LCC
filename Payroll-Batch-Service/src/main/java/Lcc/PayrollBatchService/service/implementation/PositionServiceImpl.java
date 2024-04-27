package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.respository.PositionRepository;
import Lcc.PayrollBatchService.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public String findSalaryScaleByPosition(String position) {
        return positionRepository.findSalaryScaleByPosition(position);
    }

    @Override
    public double findHousingAllowanceByPosition(String position) {
        return positionRepository.findHousingAllowanceByPosition(position);
    }

    @Override
    public double findFuelAllowanceByPosition(String position) {
        return positionRepository.findFuelAllowanceByPosition(position);
    }

    @Override
    public double findRiskAllowanceByPosition(String position) {
        return positionRepository.findRiskAllowanceByPosition(position);
    }

    @Override
    public double findTransportAllowanceByPosition(String position) {
        return positionRepository.findTransportAllowanceByPosition(position);
    }

    @Override
    public double findEducationalAllowanceByPosition(String position) {
        return positionRepository.findEducationalByPosition(position);
    }
}
