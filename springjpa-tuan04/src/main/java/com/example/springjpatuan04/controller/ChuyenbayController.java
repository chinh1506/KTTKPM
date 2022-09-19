package com.example.springjpatuan04.controller;

import com.example.springjpatuan04.model.Chuyenbay;
import com.example.springjpatuan04.repository.ChuyenbayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChuyenbayController {
    @Autowired
    private ChuyenbayRepository chuyenbayRepository;
    @RequestMapping("cau1")
    public List<Chuyenbay> cau1(){
        return  chuyenbayRepository.findByGaden("DAD");
    }
    @RequestMapping("cau4")
    public List<Chuyenbay> cau4(){
        return  chuyenbayRepository.findByDodaiBetween(8000,10000);
    }
}
