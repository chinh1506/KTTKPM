package com.example.springjpatuan04.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanvien")
public class Nhanvien {
    @Id
    private String manv;
    private String ten;
    private double luong;
    @OneToMany(mappedBy = "nhanvien")
    @JsonBackReference
    private List<Chungnhan> chungnhans;
}
