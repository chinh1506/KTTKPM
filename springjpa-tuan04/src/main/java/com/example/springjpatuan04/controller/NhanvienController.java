package com.example.springjpatuan04.controller;

import com.example.springjpatuan04.repository.NhanvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nhanvien")
public class NhanvienController {
    @Autowired
    private NhanvienRepository nhanvienRepository;

}
