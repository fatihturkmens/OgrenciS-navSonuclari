package com.notortalamasi.notortalamasi.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OgrenciDto {


    private Long ogrencino;

    @NotEmpty(message = "Ögrenci adı boş bırakılamaz")
    @Size(min = 3,max = 30)
    private String ogrenciad;

    @NotEmpty(message = "Ögrenci soyadı boş bırakılamaz")
    @Size(min = 3,max = 30)
    private String ogrencisoyad;

    private double ogrencivize;
    private double ogrencifinal;
}
