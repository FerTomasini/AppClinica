package com.example.appclinica.repository;

import com.example.appclinica.model.CartVac;
import com.example.appclinica.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartVacRepository extends JpaRepository<CartVac, Long> {

    List<CartVac> findByIdContaining(@Nullable Long id);

}
