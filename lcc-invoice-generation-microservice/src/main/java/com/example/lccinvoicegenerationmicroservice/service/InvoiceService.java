package com.example.lccinvoicegenerationmicroservice.service;

import com.example.lccinvoicegenerationmicroservice.model.Invoice;

public interface InvoiceService {
    Invoice save(Invoice invoice);
}
