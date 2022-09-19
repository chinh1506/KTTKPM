package com.example.springjpatuan04.repository;

import com.example.springjpatuan04.model.Chuyenbay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ChuyenbayRepository extends JpaRepository<Chuyenbay,String> {
    public List<Chuyenbay> findByGaden(String gaden);
    public List<Chuyenbay> findByDodaiBetween(int min, int max);

    public List<Chuyenbay> findByGadiAndGaden(String gadi, String gaden);


    public Integer countChuyenbayByGadi(String gadi);


}
