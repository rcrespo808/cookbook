package com.training.cookbook.recepie.persistence.repository;

import com.training.cookbook.recepie.persistence.entitiy.Recepie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecepieRepository extends JpaRepository<Recepie, Long> {}

