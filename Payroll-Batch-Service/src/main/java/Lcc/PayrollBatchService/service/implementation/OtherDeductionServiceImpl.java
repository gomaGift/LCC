package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.respository.OtherDeductionRepository;
import Lcc.PayrollBatchService.service.OtherDeductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OtherDeductionServiceImpl implements OtherDeductionService {

    private final OtherDeductionRepository otherDeductionRepository;


    @Override
    public double findPercentageDeductionByDeductionType(String deduction) {
        return otherDeductionRepository.findPercentageDeductionByDeductionType(deduction);
    }
}
