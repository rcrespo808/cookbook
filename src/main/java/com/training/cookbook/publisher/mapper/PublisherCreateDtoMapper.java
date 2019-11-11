package com.training.cookbook.publisher.mapper;

import com.training.cookbook.publisher.dto.PublisherCreateDto;
import com.training.cookbook.publisher.persistence.entity.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PublisherCreateDtoMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Publisher toPublisher(PublisherCreateDto publisherDto){
        return modelMapper.map(publisherDto, Publisher.class);
    }


}
