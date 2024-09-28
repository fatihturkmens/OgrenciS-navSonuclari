package com.notortalamasi.notortalamasi.Service;

import com.notortalamasi.notortalamasi.DTO.OgrenciDto;
import com.notortalamasi.notortalamasi.Model.OgrenciNotBilgisi;

import java.util.List;

public interface OgrenciService {
    public String save(OgrenciDto ogrenciDto);
    public OgrenciNotBilgisi getbyid(Long id);
    public String ogrencisil(Long id);
    public List<OgrenciNotBilgisi> tumogrenciler();
    public List<OgrenciNotBilgisi> kalanOgrenciler();
    public List<OgrenciNotBilgisi> gecenOgrenciler();
}
