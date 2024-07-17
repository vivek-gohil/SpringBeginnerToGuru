package com.borntocode.main.repositories;

import org.springframework.data.repository.CrudRepository;

import com.borntocode.main.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
