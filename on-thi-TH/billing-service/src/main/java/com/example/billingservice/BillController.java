package com.example.billingservice;

import com.example.billingservice.entity.Billing;
import com.example.billingservice.entity.BillingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BillController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private BillRepository billRepository;

    @PostMapping("/bills")
    public Billing save(@RequestBody Billing billing) {

        return billRepository.save(billing);
    }

    @GetMapping("/bills2")
    public List<BillingDto> getAll2() {
        List<BillingDto> billingDtos = new ArrayList<>();
        List<Billing> bills = billRepository.findAll();
        for (Billing bill : bills) {
            Object o = restTemplate.getForObject("http://localhost:8081/passengers/" + bill.getPassengerId(), Object.class);
            billingDtos.add(new BillingDto(bill.getBillId(), bill.getName(), bill.getPrice(), o));
        }
        return billingDtos;
    }

    @GetMapping("/bills")
    public List<Map<String, Object>> getAll() {
        List<Billing> bills = billRepository.findAll();
        List<Map<String, Object>> maps = new ArrayList<>();
        for (Billing bill : bills) {
            HashMap<String, Object> map = new HashMap<>();
            Object o = restTemplate.getForObject("http://localhost:8081/passengers/" + bill.getPassengerId(), Object.class);
            map.put("billId", bill.getBillId());
            map.put("nạme", bill.getName());
            map.put("price", bill.getPrice());
            map.put("passenger", o);
            maps.add(map);
        }
        return maps;
    }
}
