package com.amitph.spring.springdatarest.entity;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "studentView", types = Student.class)
public interface StudentView {
    Long getId();

    String getFirstName();

    String getLastName();

    @Value("#{target.lastName}, #{target.firstName}")
    String getDisplayName();

    List<Course> getCourses();
}
