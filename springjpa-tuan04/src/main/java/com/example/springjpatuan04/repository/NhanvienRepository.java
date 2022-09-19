package com.example.springjpatuan04.repository;

import com.example.springjpatuan04.model.Nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhanvienRepository extends JpaRepository<Nhanvien,String> {
    public List<Nhanvien> findByLuongLessThanEqual(double luong);


}
