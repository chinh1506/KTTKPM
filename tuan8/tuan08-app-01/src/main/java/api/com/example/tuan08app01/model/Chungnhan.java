package api.com.example.tuan08app01.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "chungnhan")
@IdClass(ChungnhanPk.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chungnhan {
    @Id
    @ManyToOne
    @JoinColumn(name = "manv")
    @JsonManagedReference
    private Nhanvien nhanvien;
    @Id
    @ManyToOne
    @JoinColumn(name = "mamb")
    @JsonManagedReference
    private Maybay maybay;

}
