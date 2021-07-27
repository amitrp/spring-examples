package com.amitph.spring.springdatarest.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourseRepository
        extends CrudRepository<Course, Long> {
}
