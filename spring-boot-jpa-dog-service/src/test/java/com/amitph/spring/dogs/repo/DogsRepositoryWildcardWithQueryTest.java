package com.amitph.spring.dogs.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DataJpaTest
@ContextConfiguration
@ActiveProfiles("jpatest")
public class DogsRepositoryWildcardWithQueryTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private DogsRepositoryWildcardWithQuery repository;

    @Test
    public void testQueryWithLike() {
        String name = "nt";
        List<Dog> expectedResults = dummyDogs().get().map(testEntityManager::persistAndFlush)
                .filter(dog -> dog.getName().contains(name)).collect(Collectors.toList());

        List<Dog> actualResults = repository.findByNameLike(name);
        Assert.assertEquals(actualResults, expectedResults);
    }

    @Test
    public void testQueryWithNotLike() {
        String name = "nt";
        List<Dog> expectedResults = dummyDogs().get().map(testEntityManager::persistAndFlush)
                .filter(dog -> !dog.getName().contains(name)).collect(Collectors.toList());

        List<Dog> actualResults = repository.findByNameNotLike(name);
        Assert.assertEquals(actualResults, expectedResults);
    }

    @Test
    public void testQueryWithStartsWith() {
        String name = "nt";
        List<Dog> expectedResults = dummyDogs().get().map(testEntityManager::persistAndFlush)
                .filter(dog -> dog.getName().startsWith(name)).collect(Collectors.toList());

        List<Dog> actualResults = repository.findByNameStartsWith(name);
        Assert.assertEquals(actualResults, expectedResults);
    }

    @Test
    public void testQueryWithEndsWith() {
        String name = "nt";
        List<Dog> expectedResults = dummyDogs().get().map(testEntityManager::persistAndFlush)
                .filter(dog -> dog.getName().endsWith(name)).collect(Collectors.toList());

        List<Dog> actualResults = repository.findByNameEndsWith(name);
        Assert.assertEquals(actualResults, expectedResults);
    }

    private Supplier<Stream<Dog>> dummyDogs() {
        return () -> Stream.of(
                new Dog("Nacho", 12),
                new Dog("Wonton", 5),
                new Dog("Fantom", 7),
                new Dog("Scooby", 3)
        );
    }
}