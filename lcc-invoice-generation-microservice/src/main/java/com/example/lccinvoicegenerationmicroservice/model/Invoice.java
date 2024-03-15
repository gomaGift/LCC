package com.example.lccinvoicegenerationmicroservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    private String identityCard;
    private String feeType;
    private String propertyId;

    public Invoice(String identityCard, String feeType, String propertyId){
        this.identityCard = identityCard;
        this.feeType = feeType;
        this.propertyId = propertyId;
    }


}
