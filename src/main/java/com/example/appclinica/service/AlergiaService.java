package com.example.appclinica.service;

import com.example.appclinica.model.Alergia;

import java.util.List;

public interface AlergiaService {

    public Long saveAlergia(Alergia alergia);

    public List<Alergia> getAllAlergias();
}
