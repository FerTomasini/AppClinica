package com.example.appclinica.repository;

import com.example.appclinica.model.CartVac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartVacRepository extends JpaRepository<CartVac, Long> {
}
