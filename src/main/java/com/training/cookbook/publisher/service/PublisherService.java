package com.training.cookbook.publisher.service;

import com.training.cookbook.exceptions.api.ApiInternalServerException;
import com.training.cookbook.exceptions.api.ApiNotFoundException;
import com.training.cookbook.publisher.entity.Publisher;
import com.training.cookbook.publisher.exception.PublisherNotFoundException;
import com.training.cookbook.publisher.mapper.PublisherDtoMapper;
import com.training.cookbook.publisher.repository.IPublisherRepository;
import com.training.cookbook.publisher.service.dto.PublisherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private IPublisherRepository repository;

    private PublisherDtoMapper mapper;

    @Autowired
    public PublisherService(IPublisherRepository repository,
                            PublisherDtoMapper dtoMapper) {
        this.repository = repository;
        this.mapper = dtoMapper;
    }

    public Publisher savePublisher(PublisherDto publisherDto){
        try{
            return repository.save(mapper.toPublisher(publisherDto));
        }
        catch(Exception e) {
            throw new ApiInternalServerException("Unable to save Publisher");
        }
    }

    public Publisher getPublisherById(Long publisherId){
        try{
            return repository.findById(publisherId).orElseThrow(() ->new PublisherNotFoundException("Unable to get Publisher with Id:" + publisherId));
        }
        catch (PublisherNotFoundException e){
            throw new ApiNotFoundException(e.getMessage());
        }
        catch(Exception e) {
            throw new ApiInternalServerException("Unable to get Publisher");
        }
    }

    public void deletePublisher(Long publisherId) {
        try{
            repository.deleteById(publisherId);
        }
        catch(Exception e) {
            throw new ApiInternalServerException("Unable to get Publisher");
        }
    }

    public Publisher updatePublisher(Publisher publisher) {

        try{
            Publisher updatePublisher = repository.findById(publisher.getId()).orElseThrow(() ->new PublisherNotFoundException("Unable to get Publisher with Id:" + publisher.getId()));;
            updatePublisher.setBiography(publisher.getBiography());
            return repository.save(updatePublisher);
        }
        catch (PublisherNotFoundException e){
            throw new ApiNotFoundException(e.getMessage());
        }
        catch(Exception e) {
            throw new ApiInternalServerException("Unable to get Publisher");
        }
    }
}
