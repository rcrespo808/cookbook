package com.training.cookbook.publisher.persistence.repository;

import com.training.cookbook.publisher.persistence.entity.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PublisherRepositoryTest {
    private PublisherRepository PublisherRepository;

    @Autowired
    public PublisherRepositoryTest(PublisherRepository PublisherRepository) {
        this.PublisherRepository = PublisherRepository;
    }

    @Test
    public void simpleTest(){
        List<Publisher> publisherList = PublisherRepository.findAll();
            assertNotNull(publisherList);
    }

    @Test
    public void databaseConnection_withValidPublisher_shouldSaveAndReturnPublisher() {
        long publisherId = 1;

        Publisher publisher = new Publisher();
        publisher.setId(publisherId);
        publisher.setUsername("TestUser1");

        PublisherRepository.save(publisher);
        Publisher result = PublisherRepository.findById(publisherId).orElse(null);

        assertEquals(publisher, result);
    }
}