package com.training.cookbook.user.mapper;

import com.training.cookbook.publisher.dto.PublisherCreateDto;
import com.training.cookbook.user.persistence.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserCreateDtoMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public User toUser(PublisherCreateDto publisherCreateDto){
        return modelMapper.map(publisherCreateDto, User.class);
    }


}
