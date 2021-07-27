package com.amitph.spring.tutorials.springdatajdbc.repo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@DataJdbcTest
@ActiveProfiles("test")
public class StudentRepositoryTest {

    @Autowired
    StudentRepository repository;

    @Test
    public void testFindByLastName() {
        List<Student> expectedList = entities()
                .map(repository::save)
                .filter(student -> student.getLastName().equals("Stark"))
                .collect(Collectors.toList());

        List<Student> actualList = repository.findByLastName("Stark");

        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testFindByLastNameIgnoreCase() {
        List<Student> expectedList = entities()
                .map(repository::save)
                .filter(student -> student.getLastName().equalsIgnoreCase("Stark"))
                .collect(Collectors.toList());

        List<Student> actualList = repository.findByLastNameIgnoreCase("Stark");
        Assert.assertEquals(expectedList, actualList);
    }

    private Stream<Student> entities() {
        return Stream.of(
                new Student(null, "Arya", "Stark", 2023),
                new Student(null, "Jon", "Snow", 2023),
                new Student(null, "Rob", "Stark", 2023),
                new Student(null, "Ned", "stark", 2023)
        );
    }
}