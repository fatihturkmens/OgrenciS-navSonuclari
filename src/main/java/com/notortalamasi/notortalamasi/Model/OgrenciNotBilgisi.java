package com.notortalamasi.notortalamasi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OgrenciNotBilgisi {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ogrencino;
    private String ogrenciad;
    private String ogrencisoyad;
    private double ogrencivize;
    private double ogrencifinal;
    private double ogrenciortalama;
    private String sonuc;
}
