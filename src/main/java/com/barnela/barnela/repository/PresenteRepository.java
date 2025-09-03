package com.barnela.barnela.repository;

import com.barnela.barnela.model.Presente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PresenteRepository extends JpaRepository<Presente, Long> {
    Optional<Presente> findByNome(String nome);
}

