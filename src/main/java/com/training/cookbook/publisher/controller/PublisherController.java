package com.training.cookbook.publisher.controller;

import com.training.cookbook.publisher.dto.PublisherCreateDto;
import com.training.cookbook.publisher.dto.PublisherDto;
import com.training.cookbook.publisher.mapper.PublisherDtoMapper;
import com.training.cookbook.publisher.service.PublisherService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/publisher")
@RestController
public class PublisherController
{
    private PublisherService publisherService;

    private PublisherDtoMapper publisherDtoMapper;


    public PublisherController(PublisherService publisherService,
                               PublisherDtoMapper publisherDtoMapper) {
        this.publisherService = publisherService;
        this.publisherDtoMapper = publisherDtoMapper;
    }

    @PostMapping(consumes = "application/json")
    public PublisherDto createPublisher(@RequestBody PublisherCreateDto publisherDto){
        return publisherService.savePublisher(publisherDto);
    }

    @GetMapping("/{id}")
    public PublisherDto getPublisherById(@PathVariable("id") Long publisherId) {
        return publisherService.getPublisherById(publisherId);
    }

    @DeleteMapping("/{id}")
    public void deletePublisherById(@PathVariable("id") Long publisherId) {
        publisherService.deletePublisher(publisherId);
    }

    @PatchMapping("/{id}")
    public PublisherDto updatePublisher(@PathVariable("id") Long publisherId, @RequestBody PublisherDto publisherDto){
        publisherDto.setId(publisherId);
        return publisherService.updatePublisher(publisherDtoMapper.toPublisher(publisherDto));
    }
}
