package com.training.cookbook.publisher.repository;

import com.training.cookbook.publisher.entitiy.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PublisherRepositoryTest {
    private PublisherRepository publisherRepository;

    @Autowired
    public PublisherRepositoryTest(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Test
    public void simpleTest(){
        List<Publisher> publisherList = publisherRepository.findAll();
            assertNotNull(publisherList);
    }

    @Test
    public void databaseConnection_withValidPublisher_shouldSaveAndReturnPublisher() {
        long publisherId = 1;

        Publisher publisher = new Publisher();
        publisher.setId(publisherId);
        publisher.setUsername("TestUser1");

        publisherRepository.save(publisher);
        Publisher result = publisherRepository.findById(publisherId).orElse(null);

        assertEquals(publisher, result);
    }
}