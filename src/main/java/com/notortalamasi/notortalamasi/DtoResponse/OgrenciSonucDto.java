package com.notortalamasi.notortalamasi.DtoResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OgrenciSonucDto {

    private Long ogrencino;
    private String ogrenciad;
    private String ogrencisoyad;
    private double ogrenciortalama;
    private String sonuc;
}
