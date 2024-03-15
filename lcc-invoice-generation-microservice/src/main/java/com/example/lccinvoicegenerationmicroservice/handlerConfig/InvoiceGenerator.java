package com.example.lccinvoicegenerationmicroservice.handlerConfig;

import com.example.lccinvoicegenerationmicroservice.model.Invoice;
import com.example.lccinvoicegenerationmicroservice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InvoiceGenerator {
    private final InvoiceRepository invoiceRepository;
    protected static Logger LOG = LoggerFactory.getLogger(InvoiceGenerator.class);

    @ExternalTaskSubscription("GenerateInvoice")
    @Bean
    public ExternalTaskHandler generateInvoice() {
        return (externalTask, externalTaskService) -> {

            // retrieve a variable from the Process Engine
            String identityCard = externalTask.getVariable("identityCard");
            String feeType = externalTask.getVariable("feeType");
            String propertyNum = externalTask.getVariable("propertyNum");

            Invoice invoice = new Invoice(identityCard, feeType, propertyNum);

            invoiceRepository.save(invoice);
            externalTaskService.complete(externalTask);
            LOG.info("Invoice identityCard: '{}', invoice fee type: '{}', invoice property number is: '{}'",
                    invoice.getIdentityCard(), invoice.getFeeType(), invoice.getPropertyId());

        };


    }
}


