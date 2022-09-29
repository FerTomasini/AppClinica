package com.example.appclinica.service;

import com.example.appclinica.model.ProblemaSaude;

import java.util.List;

public interface ProblemaSaudeService {

    public Long saveProblema(ProblemaSaude problema);

    public List<ProblemaSaude> getAllProblemas();
}
