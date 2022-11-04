package com.example.appclinica.service;

import com.example.appclinica.model.ProblemaSaude;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public interface ProblemaSaudeService {

    public Long saveProblema(ProblemaSaude problema);

    public List<ProblemaSaude> getAllProblemas();
}
