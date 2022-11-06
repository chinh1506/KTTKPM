package com.example.billingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Billing {
    @Id
    @Column(name = "bill_id")
    private String billId;
    private String name;
    private double price;
    @Column(name = "passenger_id")
    private String passengerId;
}
