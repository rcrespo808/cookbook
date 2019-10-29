package com.training.cookbook.publisher.repository;

import com.training.cookbook.Utils.DateUtil;
import com.training.cookbook.exceptions.api.ApiNotFoundException;
import com.training.cookbook.publisher.entity.Publisher;
import org.springframework.stereotype.Repository;

@Repository
public abstract class PublisherRepository implements IPublisherRepository {
    public void deleteById(Long id) {
        Publisher publisher = this.findById(id).orElseThrow(() -> new ApiNotFoundException("Counld Not find Publisher" + id));
        publisher.setDeleteDate(DateUtil.Today());
        this.save(publisher);
    }
}
