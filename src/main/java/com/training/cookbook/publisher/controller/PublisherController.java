package com.training.cookbook.publisher.controller;

import com.training.cookbook.publisher.controller.dto.PublisherCreateDto;
import com.training.cookbook.publisher.controller.dto.PublisherUpdateDto;
import com.training.cookbook.publisher.entity.Publisher;
import com.training.cookbook.publisher.mapper.PublisherCreateDtoMapper;
import com.training.cookbook.publisher.mapper.PublisherUpdateDtoMapper;
import com.training.cookbook.publisher.service.PublisherService;
import com.training.cookbook.publisher.service.dto.PublisherDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/publisher")
@RestController
public class PublisherController
{
    @Autowired
    private PublisherService publisherService;

    @Autowired
    private PublisherCreateDtoMapper publisherCreateDtoMapper;

    @Autowired
    private PublisherUpdateDtoMapper publisherUpdateDtoMapper;

    @Autowired
    public PublisherController(PublisherService publisherService,
                               PublisherCreateDtoMapper createDtoMapper,
                               PublisherUpdateDtoMapper updateDtoMapper) {
        this.publisherService = publisherService;
        this.publisherCreateDtoMapper = createDtoMapper;
        this.publisherUpdateDtoMapper = updateDtoMapper;
    }

    @PostMapping(consumes = "application/json")
    public Publisher postPublisher(@RequestBody PublisherCreateDto publisherCreateDto){
        return publisherService.savePublisher(publisherCreateDtoMapper.toPublisherDto(publisherCreateDto));
    }

    @GetMapping("/{id}")
    public Publisher getPublisher(@PathVariable("id") Long publisherId) {
        return publisherService.getPublisherById(publisherId);

    }

    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable("id") Long publisherId) {
        publisherService.deletePublisher(publisherId);
    }

    @PatchMapping("/{id}")
    public Publisher patchPublisher(@PathVariable("id") Long publisherId, @RequestBody PublisherUpdateDto publisher){
        publisher.setId(publisherId);
        return publisherService.updatePublisher(publisherUpdateDtoMapper.toPublisher(publisher));
    }
}
