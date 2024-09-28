package com.notortalamasi.notortalamasi.Serviceİmpl;

import com.notortalamasi.notortalamasi.DTO.OgrenciDto;
import com.notortalamasi.notortalamasi.Model.OgrenciNotBilgisi;
import com.notortalamasi.notortalamasi.Repository.OgrenciRepository;
import com.notortalamasi.notortalamasi.Service.OgrenciService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OgrenciServiceİmpl implements OgrenciService {

    @Autowired
    private OgrenciRepository ogrenciRepository;


    private String dtomapper(OgrenciNotBilgisi ogrenciNotBilgisi, OgrenciDto ogrenciDto){
        ogrenciNotBilgisi.setOgrencino(ogrenciDto.getOgrencino());
        ogrenciNotBilgisi.setOgrenciad(ogrenciDto.getOgrenciad());
        ogrenciNotBilgisi.setOgrencisoyad(ogrenciDto.getOgrencisoyad());
        ogrenciNotBilgisi.setOgrencivize(ogrenciDto.getOgrencivize());
        ogrenciNotBilgisi.setOgrencifinal(ogrenciDto.getOgrencifinal());

        double ogrencivize = ogrenciDto.getOgrencivize();
        double ogrencifinal = ogrenciDto.getOgrencifinal();

        double ortalama =  (ogrencivize*(0.30))+(ogrencifinal*(0.70)) ;
         ogrenciNotBilgisi.setOgrenciortalama(ortalama);
         if (ortalama>=50){
             ogrenciNotBilgisi.setSonuc("geçti");
         }
         else {
             ogrenciNotBilgisi.setSonuc("kaldı");
         }
         ogrenciRepository.save(ogrenciNotBilgisi);
         return "Öğrenci bilgileri kaydedildi";
    }

      public String save(OgrenciDto ogrenciDto){
       return dtomapper(new OgrenciNotBilgisi(),ogrenciDto);
      }


      public OgrenciNotBilgisi getbyid(Long id){
        Optional<OgrenciNotBilgisi> ogrenciNotBilgisi =ogrenciRepository.findById(id);
        if (ogrenciNotBilgisi.isPresent()){
            return ogrenciNotBilgisi.get();
        }
        else {
            throw new EntityNotFoundException("Ögrenci bulunamadı");
        }

      }

      public String ogrencisil(Long id){
        Optional<OgrenciNotBilgisi> ogrenciNotBilgisi =ogrenciRepository.findById(id);
        if (ogrenciNotBilgisi.isPresent()){
             ogrenciRepository.deleteById(id);
             return "Ögrenci bilgileri silindi";
        }
        else {
            throw new EntityNotFoundException("Ögrenci bulunamadı");
        }


      }
      public List<OgrenciNotBilgisi>tumogrenciler(){
      return   ogrenciRepository.findAll();
      }

      public List<OgrenciNotBilgisi> kalanOgrenciler(){
          List<OgrenciNotBilgisi> kalanogrenciler = new ArrayList<>();
          List<OgrenciNotBilgisi> ogrenciler =ogrenciRepository.findAll();
          for (OgrenciNotBilgisi ogrenci:ogrenciler) {
              if (ogrenci.getOgrenciortalama() <= 50) {
                  kalanogrenciler.add(ogrenci);
              }
          }
          return kalanogrenciler;

      }
    public List<OgrenciNotBilgisi> gecenOgrenciler(){
        List<OgrenciNotBilgisi> gecenogrenciler = new ArrayList<>();
        List<OgrenciNotBilgisi> ogrenciler =ogrenciRepository.findAll();
        for (OgrenciNotBilgisi ogrenci:ogrenciler) {
            if (ogrenci.getOgrenciortalama() >= 50) {
                gecenogrenciler.add(ogrenci);
            }
        }
        return gecenogrenciler;

    }

      }

