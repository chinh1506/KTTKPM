package com.example.springjpatuan04;

import com.example.springjpatuan04.model.Chuyenbay;
import com.example.springjpatuan04.model.Maybay;
import com.example.springjpatuan04.model.Nhanvien;
import com.example.springjpatuan04.repository.ChuyenbayRepository;
import com.example.springjpatuan04.repository.MaybayRepository;
import com.example.springjpatuan04.repository.NhanvienRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestJPA {
    @Autowired
    private ChuyenbayRepository chuyenbayRepository;
    @Autowired
    private MaybayRepository maybayRepository;
    @Autowired
    private NhanvienRepository nhanvienRepository;

    @Test
    void cau1() {
        System.out.println(chuyenbayRepository.findByGaden("DAD"));
    }

    @Test
    void cau2() {
        List<Maybay> result = maybayRepository.findByTambayMoreThanNKm(10000);
        System.out.println(result);
    }

    @Test
    void cau3() {
        System.out.println(nhanvienRepository.findByLuongLessThanEqual(10000));
    }

    @Test
    void cau4() {
        System.out.println(chuyenbayRepository.findByDodaiBetween(8000, 10000));
    }

    @Test
    void cau5() {
        System.out.println(chuyenbayRepository.findByGadiAndGaden("SGN", "BWV"));
    }

    @Test
    void cau6() {
        System.out.println(chuyenbayRepository.countChuyenbayByGadi("SGN"));
    }

    @Test
    void cau7() {
        System.out.println(maybayRepository.countMaybayByLoai("Boeing"));
    }

    @Test
    void cau8() {
        System.out.println(nhanvienRepository.getSumByLuong());
    }

    @Test
    void cau9() {
        nhanvienRepository.findByMaybay("Boeing").forEach(nhanvien -> {
            System.out.println(nhanvien.getManv());
        });
    }

    @Test
    void cau10() {
        System.out.println(nhanvienRepository.findByMaMaybay(747));
    }

    @Test
    void cau11() {
        System.out.println(maybayRepository.findByHoNhanvien("Nguyen"));
    }

    @Test
    void cau12() {
        System.out.println(nhanvienRepository.findIdBy2Loaimb("Airbus", "Boeing"));
    }

    @Test
    void cau13() {
        System.out.println(maybayRepository.findByMacb("VN280"));
    }

    @Test
    void cau14() {
        System.out.println(chuyenbayRepository.findByMayBay("Airbus A320"));
    }

    @Test
    void cau15() {
        nhanvienRepository.findByMaybay("Boeing").forEach(nhanvien -> {
            System.out.println(nhanvien.getTen());
        });
    }

    @Test
    void cau16() {
        maybayRepository.countNhanVienByMaybay().forEach(m -> {
            Object[] result= (Object[])m;
            System.out.println( result[0]+" "+(String)result[1]+" "+result[2]);
        });

    }

    @Test
    void cau17() {
        System.out.println(chuyenbayRepository.findByDuongBay("SGN","DAD"));
    }

    @Test
    void cau18() {
        chuyenbayRepository.countChuyenbayByGadi().forEach(c->{
            Object[] objects= (Object[])c;
            System.out.println((Chuyenbay)objects[0]+" "+objects[1]);
        });
    }

    @Test
    void cau19() {
        chuyenbayRepository.estimateSumChiphi().forEach(c->{
            Object[] objects= (Object[])c;
            System.out.println((Chuyenbay)objects[0]+" "+objects[1]);
        });
    }

    @Test
    void cau20() {

        LocalTime localTime=LocalTime.of(12,00);
        chuyenbayRepository.findByGiodiBefore(localTime).forEach(c->{
            System.out.println(c);
        });
    }

    @Test
    void cau21() {
        LocalTime localTime=LocalTime.of(12,00);
        chuyenbayRepository.countChuyenBayForGadiBefore(localTime).forEach(c->{
            Object[] objects= (Object[])c;
            System.out.println((String)objects[0]+" "+objects[1]);
        });
    }

    @Test
    void cau22() {
        nhanvienRepository.findBySoLoaimb(3).forEach(i->{
            Object[] objects= (Object[])i;
            System.out.println((Nhanvien)objects[0]+" "+objects[1]);
        });
    }

    @Test
    void cau23() {
        nhanvienRepository.findBySoLoaimbMoreThanEqual(3).forEach(i->{
            Object[] objects= (Object[])i;
            System.out.println((Nhanvien)objects[0]+" "+objects[1]);
        });
    }

    @Test
    void cau24() {
        nhanvienRepository.countMaybayOfNv().forEach(i->{
            Object[] objects= (Object[])i;
            System.out.println(((Nhanvien)objects[0]).getManv()+" "+objects[1]);
        });
    }

    @Test
    void cau25() {
        nhanvienRepository.findByNotChungnhan().forEach(nhanvien -> {
            System.out.println(nhanvien);
        });
    }

    @Test
    void cau26() {
        nhanvienRepository.findByLuongMax().forEach(nhanvien -> {
            System.out.println(nhanvien.getManv());
        });
    }

    @Test
    void cau27() {
        System.out.println(nhanvienRepository.getSumLuongPhicong());
    }

    @Test
    void cau28() {
       chuyenbayRepository.findByLoaiMaybay("Boeing").forEach(chuyenbay -> {
           System.out.println(chuyenbay);
       });
    }


}
