package com.example.billingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingDto {
    private String billId;
    private String name;
    private double price;
    private Object passenger;
}
