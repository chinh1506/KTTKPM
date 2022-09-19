package com.example.springjpatuan04.controller;

import com.example.springjpatuan04.model.Maybay;
import com.example.springjpatuan04.repository.MaybayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaybayController {
    @Autowired
    private MaybayRepository maybayRepository;

    @GetMapping("cau2")
    public List<Maybay> cau2(){
        return maybayRepository.findByTambayMoreThanNKm(10000);
    }
    @GetMapping("cau7")
    public Integer cau7(){
        return maybayRepository.countMaybayByLoai("Boeing");
    }
}
