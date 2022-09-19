package com.example.springjpatuan04.repository;

import com.example.springjpatuan04.model.Maybay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaybayRepository extends JpaRepository<Maybay,Integer> {

    @Query(value = "select * from maybay where tambay>=?1",nativeQuery = true)
    public List<Maybay> findByTambayMoreThanNKm(Integer tambay);

    @Query(value = "select  count(*) from maybay where loai like %?1%",nativeQuery = true)
    public Integer countMaybayByLoai(String loai);

    @Query(value = "select * from maybay mb inner join chungnhan cn on mb.mamb=cn.mamb" +
            "    inner join nhanvien nv on cn.manv= nv.manv where nv.ten like ?1%",nativeQuery = true)
    public List<Maybay> findByHoNhanvien(String honv);

}
