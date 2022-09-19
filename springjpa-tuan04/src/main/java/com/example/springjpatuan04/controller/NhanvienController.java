package com.example.springjpatuan04.controller;

import com.example.springjpatuan04.model.Nhanvien;
import com.example.springjpatuan04.repository.NhanvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NhanvienController {
    @Autowired
    private NhanvienRepository nhanvienRepository;
    @GetMapping("cau3")
    public List<Nhanvien> cau3(){
        return nhanvienRepository.findByLuongLessThanEqual(10000);
    }
}
