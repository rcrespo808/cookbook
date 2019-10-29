package com.training.cookbook.publisher.repository;

import com.training.cookbook.publisher.entity.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PublisherRepositoryTest {
    private IPublisherRepository IPublisherRepository;

    @Autowired
    public PublisherRepositoryTest(IPublisherRepository IPublisherRepository) {
        this.IPublisherRepository = IPublisherRepository;
    }

    @Test
    public void simpleTest(){
        List<Publisher> publisherList = IPublisherRepository.findAll();
            assertNotNull(publisherList);
    }

    @Test
    public void databaseConnection_withValidPublisher_shouldSaveAndReturnPublisher() {
        long publisherId = 1;

        Publisher publisher = new Publisher();
        publisher.setId(publisherId);
        publisher.setUsername("TestUser1");

        IPublisherRepository.save(publisher);
        Publisher result = IPublisherRepository.findById(publisherId).orElse(null);

        assertEquals(publisher, result);
    }
}