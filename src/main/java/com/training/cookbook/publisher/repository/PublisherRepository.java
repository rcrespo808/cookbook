package com.training.cookbook.publisher.repository;

import com.training.cookbook.publisher.entitiy.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
