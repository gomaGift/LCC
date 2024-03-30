package Lcc.PayrollBatchService.service;

import Lcc.PayrollBatchService.model.Insurance;

public interface InsuranceService {


    double findPercentageContributionByInsuranceType(String insuranceType);
}
