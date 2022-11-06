package com.example.billingservice;

import com.example.billingservice.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Billing, String> {
}
