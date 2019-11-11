package com.training.cookbook.publisher.persistence.repository;

import com.training.cookbook.publisher.persistence.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {}
