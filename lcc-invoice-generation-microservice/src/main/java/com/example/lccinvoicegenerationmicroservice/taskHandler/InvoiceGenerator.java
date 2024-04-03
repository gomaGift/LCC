package com.example.lccinvoicegenerationmicroservice.taskHandler;

import com.example.lccinvoicegenerationmicroservice.model.Invoice;
import com.example.lccinvoicegenerationmicroservice.repository.InvoiceRepository;
import com.example.lccinvoicegenerationmicroservice.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
/*
* camunda external task handler for invoice creation
* */
@ExternalTaskSubscription(
        topicName = "GenerateInvoice",
        processDefinitionKey = "invoice_generation",
        variableNames = {"identityCard", "feeType", "propertyNum"},
        autoOpen = true
)
@RequiredArgsConstructor
@Component
public class InvoiceGenerator implements ExternalTaskHandler{

    private final InvoiceService invoiceService;
    protected static Logger LOG = LoggerFactory.getLogger(InvoiceGenerator.class);
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
          // retrieve variables passed from camunda to create an invoice
          String identityCard = externalTask.getVariable("identityCard");
          String feeType = externalTask.getVariable("feeType");
          String propertyNum = externalTask.getVariable("propertyNum");

          Invoice invoice = new Invoice(identityCard, feeType, propertyNum);
          Invoice savedInvoice = invoiceService.save(invoice);
          LOG.info("Invoice with identity card {}, fee type {} and property number {} created successfully",
                  savedInvoice.getIdentityCard(), savedInvoice.getFeeType(), savedInvoice.getPropertyId());
          externalTaskService.complete(externalTask);
    }
}


