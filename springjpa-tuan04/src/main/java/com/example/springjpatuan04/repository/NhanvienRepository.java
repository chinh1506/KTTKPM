package com.example.springjpatuan04.repository;

import com.example.springjpatuan04.model.Nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NhanvienRepository extends JpaRepository<Nhanvien,String> {
    public List<Nhanvien> findByLuongLessThanEqual(double luong);
    @Query(value = "select sum(luong) from nhanvien",nativeQuery = true)
    public Double getSumByLuong();


}
