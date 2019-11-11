package com.training.cookbook.publisher.service;

import com.training.cookbook.publisher.dto.PublisherCreateDto;
import com.training.cookbook.publisher.dto.PublisherDto;
import com.training.cookbook.publisher.mapper.PublisherCreateDtoMapper;
import com.training.cookbook.publisher.mapper.PublisherDtoMapper;
import com.training.cookbook.publisher.persistence.entity.Publisher;
import com.training.cookbook.publisher.persistence.repository.PublisherRepository;
import com.training.cookbook.user.mapper.UserCreateDtoMapper;
import com.training.cookbook.user.persistence.entity.User;
import com.training.cookbook.user.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class PublisherCreationFacade {

    private final PublisherRepository publisherRepository;

    private final UserRepository userRepository;

    private final UserCreateDtoMapper userCreateDtoMapper;

    private final PublisherCreateDtoMapper publisherCreateDtoMapper;

    private final PublisherDtoMapper publisherDtoMapper;

    public PublisherCreationFacade(PublisherRepository publisherRepository, UserRepository userRepository, UserCreateDtoMapper userCreateDtoMapper, PublisherCreateDtoMapper publisherCreateDtoMapper, PublisherDtoMapper publisherDtoMapper) {
        this.publisherRepository = publisherRepository;
        this.userRepository = userRepository;
        this.userCreateDtoMapper = userCreateDtoMapper;
        this.publisherCreateDtoMapper = publisherCreateDtoMapper;
        this.publisherDtoMapper = publisherDtoMapper;
    }

    public PublisherDto CreatePublisherWithUser(PublisherCreateDto publisherCreateDto) {
        Publisher publisher = publisherCreateDtoMapper.toPublisher(publisherCreateDto);
        User user = userCreateDtoMapper.toUser(publisherCreateDto);

        user = userRepository.save(user);
        publisher.setUser(user);
        publisher = publisherRepository.save(publisher);
        return publisherDtoMapper.toPublisherDto(publisher);
    }

}
