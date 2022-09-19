package com.example.springjpatuan04.repository;

import com.example.springjpatuan04.model.Maybay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaybayRepository extends JpaRepository<Maybay,Integer> {

    @Query(value = "select * from maybay where tambay>=?1 group by loai",nativeQuery = true)
    public List<Maybay> findByTambayMoreThanNKm(Integer tambay);

}
