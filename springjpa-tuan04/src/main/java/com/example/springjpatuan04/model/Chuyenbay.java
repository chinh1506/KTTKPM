package com.example.springjpatuan04.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "chuyenbay")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chuyenbay {
    @Id
    private String macb;
    private String gadi;
    private String gaden;
    private int dodai;
    private Date giodi;
    private Date gioden;
    private Double chiphi;
}
