package com.training.cookbook.publisher.mapper;

import com.training.cookbook.publisher.dto.PublisherDto;
import com.training.cookbook.publisher.persistence.entity.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PublisherDtoMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Publisher toPublisher(PublisherDto publisherDto){
        return modelMapper.map(publisherDto, Publisher.class);
    }

    public PublisherDto toPublisherDto(Publisher publisher){
        return modelMapper.map(publisher, PublisherDto.class);
    }

}
