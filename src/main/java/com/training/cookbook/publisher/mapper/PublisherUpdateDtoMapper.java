package com.training.cookbook.publisher.mapper;

import com.training.cookbook.publisher.controller.dto.PublisherUpdateDto;
import com.training.cookbook.publisher.entity.Publisher;
import com.training.cookbook.publisher.service.dto.PublisherDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PublisherUpdateDtoMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public Publisher toPublisher(PublisherUpdateDto publisherUpdateDto){
        return modelMapper.map(publisherUpdateDto, Publisher.class);
    }
}
