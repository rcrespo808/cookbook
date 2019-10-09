package com.training.cookbook.publisher.repository;

import com.training.cookbook.publisher.entitiy.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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
    public void writeTest(){
        Publisher publisher = new Publisher();
        publisher.setId(9000L);
        publisher.setUsername("TestUser");

        final Publisher save = publisherRepository.save(publisher);

        assertEquals(save,publisher);
    }

    @Test
    public void readTest(){
        Publisher publisher = new Publisher();
        publisher.setId(9001L);
        publisher.setUsername("TestUser2");

        publisherRepository.save(publisher);

        Optional<Publisher> load = publisherRepository.findById(9001L);

        assertNotNull(load);
        assertEquals(load.get(),publisher);
    }
}