package com.example.appclinica.repository;

import com.example.appclinica.model.ProblemaSaude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemaSaudeRepository extends JpaRepository<ProblemaSaude, Long> {
}
