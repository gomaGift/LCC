package Lcc.PayrollBatchService.payrollGenerator;

import Lcc.PayrollBatchService.model.Payroll;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PayrollPdfGenerator {

    private final PayrollDataMapper payrollDataMapper;
    private final PayrollHtmlPdfConverter payrollHtmlPdfConverter;
    private final SpringTemplateEngine templateEngine;

    public void generatePayroll(List<Payroll> payrollList){
        String finalHtml = null;
        Context context = payrollDataMapper.setData(payrollList);
        finalHtml = templateEngine.process("payroll_table", context);
        payrollHtmlPdfConverter.htmlToPdf(finalHtml);
    }
}
