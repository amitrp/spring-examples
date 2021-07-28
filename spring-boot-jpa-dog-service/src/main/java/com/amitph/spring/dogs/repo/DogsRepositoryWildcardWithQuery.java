package com.amitph.spring.dogs.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogsRepositoryWildcardWithQuery extends CrudRepository<Dog, Long> {

    @Query("FROM Dog d WHERE d.name LIKE %:name%")
    List<Dog> findByNameLike(@Param("name") String name);

    @Query("FROM Dog d WHERE d.name NOT LIKE %:name%")
    List<Dog> findByNameNotLike(@Param("name") String name);

    @Query("FROM Dog d WHERE d.name LIKE :name%")
    List<Dog> findByNameStartsWith(@Param("name") String name);

    @Query("FROM Dog d WHERE d.name LIKE %:name")
    List<Dog> findByNameEndsWith(@Param("name") String name);
}