package com.example.springjpatuan04.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "maybay")
public class Maybay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mamb;
    private String loai;
    private int tambay;

    @OneToMany(mappedBy = "maybay")
    @JsonBackReference
    private List<Chungnhan> chungnhans;
}
