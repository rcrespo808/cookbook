package com.training.cookbook.recepie.controller;

import com.training.cookbook.recepie.dto.RecepieCreateDto;
import com.training.cookbook.recepie.dto.RecepieDto;
import com.training.cookbook.recepie.mapper.RecepieCreateDtoMapper;
import com.training.cookbook.recepie.mapper.RecepieDtoMapper;
import com.training.cookbook.recepie.service.RecepieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/recepie")
@RestController
public class RecepieController {

    private RecepieService recepieService;

    private RecepieDtoMapper recepieDtoMapper;

    private RecepieCreateDtoMapper recepieCreateDtoMapper;

    public RecepieController(RecepieService recepieService, RecepieDtoMapper recepieDtoMapper, RecepieCreateDtoMapper recepieCreateDtoMapper) {
        this.recepieService = recepieService;
        this.recepieDtoMapper = recepieDtoMapper;
        this.recepieCreateDtoMapper = recepieCreateDtoMapper;
    }

    @PostMapping(consumes = "application/json")
    RecepieDto CreateRecepie(@RequestBody RecepieCreateDto recepieDto){
        return recepieDtoMapper.toRecepieDto(recepieService.CreateRecepie(recepieCreateDtoMapper.toRecepie(recepieDto)));
    }
}
