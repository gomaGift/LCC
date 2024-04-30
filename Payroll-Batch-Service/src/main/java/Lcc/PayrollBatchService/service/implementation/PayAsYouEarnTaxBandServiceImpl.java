package Lcc.PayrollBatchService.service.implementation;

import Lcc.PayrollBatchService.model.PayAsYouEarnTaxBand;
import Lcc.PayrollBatchService.respository.PayAsYouEarnTaxBandRepository;
import Lcc.PayrollBatchService.service.PayAsYouEarnTaxBandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayAsYouEarnTaxBandServiceImpl implements PayAsYouEarnTaxBandService {
    @Autowired
    private PayAsYouEarnTaxBandRepository payAsYouEarnTaxBandRepository;
    @Override
    public List<PayAsYouEarnTaxBand> findAll() {
        return payAsYouEarnTaxBandRepository.findAll();
    }
}
