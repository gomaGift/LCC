package com.example.lccinvoicegenerationmicroservice.service.impl;

import com.example.lccinvoicegenerationmicroservice.model.Invoice;
import com.example.lccinvoicegenerationmicroservice.repository.InvoiceRepository;
import com.example.lccinvoicegenerationmicroservice.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImplementation implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
