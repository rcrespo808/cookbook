package com.training.cookbook.publisher.service;

import com.training.cookbook.publisher.persistence.repository.PublisherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class PublisherServiceTest {

    @Autowired
    PublisherService publisherService;
    PublisherRepository publisherResource;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void savePublisher() {
    }

    @Test
    void getPublisherById() {
    }
}