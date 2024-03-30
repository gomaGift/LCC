package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.model.Insurance;
import Lcc.PayrollBatchService.respository.InsuranceRepository;
import Lcc.PayrollBatchService.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;


    @Override
    public double findPercentageContributionByInsuranceType(String insuranceType) {
        return insuranceRepository.findPercentageContributionByInsuranceType(insuranceType);

    }
}
