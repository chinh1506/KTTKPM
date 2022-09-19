package com.example.springjpatuan04.repository;

import com.example.springjpatuan04.model.Nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NhanvienRepository extends JpaRepository<Nhanvien,String> {
    public List<Nhanvien> findByLuongLessThanEqual(double luong);
    @Query(value = "select sum(luong) from nhanvien",nativeQuery = true)
    public Double getSumByLuong();

    @Query(value = "select nv.manv from nhanvien nv inner join chungnhan cn on nv.manv=cn.manv\n" +
            "            inner join maybay mb on cn.mamb= mb.mamb where loai like %?1%",nativeQuery = true)
    public List<String> getIdByMaybay(String loai);

}
