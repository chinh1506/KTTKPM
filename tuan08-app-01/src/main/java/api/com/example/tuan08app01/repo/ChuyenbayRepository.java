package api.com.example.tuan08app01.repo;

import api.com.example.tuan08app01.model.Chuyenbay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.List;


public interface ChuyenbayRepository extends JpaRepository<Chuyenbay, String> {
    public List<Chuyenbay> findByGaden(String gaden);

    public List<Chuyenbay> findByDodaiBetween(int min, int max);

    public List<Chuyenbay> findByGadiAndGaden(String gadi, String gaden);


    public Integer countChuyenbayByGadi(String gadi);

    @Query("select cb from Maybay mb,Chuyenbay cb " +
            "where mb.loai=?1 and cb.dodai <= mb.tambay")
    public List<Chuyenbay> findByMayBay(String loaimb);

    @Query(value = "select * from chuyenbay where (gadi=?1 and gaden=?2) or (gadi=?2 and gaden=?1)", nativeQuery = true)
    public List<Chuyenbay> findByDuongBay(String gadi, String gaden);
    @Query(value = "select cb, (select count(c.gadi) from Chuyenbay c where c.gadi=cb.gadi) " +
        " from Chuyenbay cb group by cb.macb,cb.gaden")
    public List<?> countChuyenbayByGadi();

    @Query("select c, (select sum(cb.chiphi) from Chuyenbay cb where cb.gadi=c.gadi) from Chuyenbay c group by c.macb")
    public List<?> estimateSumChiphi();


    public List<Chuyenbay> findByGiodiBefore(LocalTime giodi);

    @Query(value = "select c.gadi,count(*) from chuyenbay c where c.giodi<=?1 group by c.gadi",nativeQuery = true)
    public List<?> countChuyenBayForGadiBefore(LocalTime time);

    @Query("select c from Chuyenbay c where c.dodai<= (select min(m.tambay) from  Maybay m where m.loai like ?1%)")
    public List<Chuyenbay> findByLoaiMaybay(String loai);
}
