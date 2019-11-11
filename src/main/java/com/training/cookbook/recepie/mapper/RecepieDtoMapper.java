package com.training.cookbook.recepie.mapper;

import com.training.cookbook.recepie.dto.RecepieDto;
import com.training.cookbook.recepie.persistence.entitiy.Recepie;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class RecepieDtoMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public RecepieDto toRecepieDto(Recepie recepie){
        return modelMapper.map(recepie, RecepieDto.class);
    }

}
