package com.amitph.spring.dogs.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogsRepositoryWildcardWithQueryMethods extends CrudRepository<Dog, Long> {

    List<Dog> findByNameContaining(String name);

    List<Dog> findByNameNotContaining(String name);

    List<Dog> findByNameStartsWith(String name);

    List<Dog> findByNameEndsWith(String name);
}
