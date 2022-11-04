package com.example.appclinica.service;

import com.example.appclinica.model.Alergia;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public interface AlergiaService {

    public Long saveAlergia(Alergia alergia);

    public List<Alergia> getAllAlergias();
}
