package com.training.cookbook.publisher.service;

import com.training.cookbook.exceptions.api.ApiInternalServerException;
import com.training.cookbook.exceptions.api.ApiNotFoundException;
import com.training.cookbook.publisher.dto.PublisherCreateDto;
import com.training.cookbook.publisher.dto.PublisherDto;
import com.training.cookbook.publisher.mapper.PublisherDtoMapper;
import com.training.cookbook.publisher.persistence.entity.Publisher;
import com.training.cookbook.publisher.persistence.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    private final PublisherDtoMapper publisherDtoMapper;

    private final PublisherCreationFacade publisherCreationFacade;

    public PublisherService(PublisherRepository publisherRepository, PublisherDtoMapper publisherDtoMapper, com.training.cookbook.publisher.service.PublisherCreationFacade publisherCreationFacade) {
        this.publisherRepository = publisherRepository;
        this.publisherDtoMapper = publisherDtoMapper;
        this.publisherCreationFacade = publisherCreationFacade;
    }

    public PublisherDto savePublisher(PublisherCreateDto publisherCreateDto){
        return publisherCreationFacade.CreatePublisherWithUser(publisherCreateDto);
    }

    public PublisherDto getPublisherById(Long publisherId){
            return publisherDtoMapper.toPublisherDto(publisherRepository.findById(publisherId)
                    .orElseThrow(() ->new ApiNotFoundException("Unable to get Publisher with Id:" + publisherId)));
    }

    public void deletePublisher(Long publisherId) {
        try{
            publisherRepository.deleteById(publisherId);
        }
        catch(Exception e) {
            throw new ApiInternalServerException("Unable to get Publisher");
        }
    }

    public PublisherDto updatePublisher(Publisher publisher) {
            Publisher updatePublisher = publisherRepository.findById(publisher.getId())
                    .orElseThrow(() ->new ApiNotFoundException("Unable to get Publisher with Id:" + publisher.getId()));;
            updatePublisher.setBiography(publisher.getBiography());
            return publisherDtoMapper.toPublisherDto(publisherRepository.save(updatePublisher));
    }
}
