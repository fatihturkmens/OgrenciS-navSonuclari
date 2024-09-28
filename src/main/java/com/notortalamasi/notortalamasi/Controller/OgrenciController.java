package com.notortalamasi.notortalamasi.Controller;

import com.notortalamasi.notortalamasi.DTO.OgrenciDto;
import com.notortalamasi.notortalamasi.Model.OgrenciNotBilgisi;
import com.notortalamasi.notortalamasi.Service.OgrenciService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ogrenci")
public class OgrenciController {

        @Autowired
        private OgrenciService ogrenciService;

       @PostMapping("/ekle")
        public ResponseEntity<String> ogrenciekle(@RequestBody @Valid OgrenciDto ogrenciDto){
        String sonuc =  ogrenciService.save(ogrenciDto);
          return new ResponseEntity<>(sonuc, HttpStatus.CREATED);
        }

        @GetMapping("/ogrenci/{id}")
        public ResponseEntity<OgrenciNotBilgisi> ogrenci(@PathVariable Long id){
           OgrenciNotBilgisi ogrenciNotBilgisi =ogrenciService.getbyid(id);
           return new ResponseEntity<>(ogrenciNotBilgisi,HttpStatus.OK);
        }
        @GetMapping("/kalanogrenciler")
        public ResponseEntity<List<OgrenciNotBilgisi>> kalanOgrenciler(){
          List<OgrenciNotBilgisi> kalanogrenciler= ogrenciService.kalanOgrenciler();
          return new ResponseEntity<>(kalanogrenciler,HttpStatus.OK);
        }
        @GetMapping("/gecenogrenciler")
        public ResponseEntity<List<OgrenciNotBilgisi>> gecenOgrenciler(){
           List<OgrenciNotBilgisi> gecenOgrenciler= ogrenciService.gecenOgrenciler();
           return new ResponseEntity<>(gecenOgrenciler,HttpStatus.OK);
        }

        @GetMapping("/all")
       public ResponseEntity<List<OgrenciNotBilgisi>> tumOgrenciler(){
         List<OgrenciNotBilgisi> all =  ogrenciService.tumogrenciler();
         return new ResponseEntity<>(all,HttpStatus.OK);
        }
        @DeleteMapping("delete/{id}")
       public ResponseEntity<String> ogrencisil(@PathVariable Long id){
           ogrenciService.ogrencisil(id);
           return new ResponseEntity<>("ögrenci silindi",HttpStatus.OK);
        }
}
