package com.example.springjpatuan04.model;

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
    private Nhanvien nhanvien;
    @Id
    @ManyToOne
    @JoinColumn(name = "mamb")
    private Maybay maybay;

}
