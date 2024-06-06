package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.respository.OtherDeductionRepository;
import Lcc.PayrollBatchService.service.OtherDeductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class OtherDeductionServiceImpl implements OtherDeductionService {
    @Autowired
    private OtherDeductionRepository otherDeductionRepository;


    @Override
    public double findPercentageDeductionByDeductionType(String deduction) {
        return otherDeductionRepository.findPercentageDeductionByDeductionType(deduction);
    }
}
