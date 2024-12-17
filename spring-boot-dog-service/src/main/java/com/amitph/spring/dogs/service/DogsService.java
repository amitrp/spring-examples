package com.amitph.spring.dogs.service;

import com.amitph.spring.dogs.model.DogDto;
import com.amitph.spring.dogs.repo.Dog;
import com.amitph.spring.dogs.repo.MockDogProvider;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Setter
public class DogsService {
    private final MockDogProvider mockDogProvider;

    public void add(DogDto dto) {
        mockDogProvider.add(dto);
    }

    public void delete(long id) {
        mockDogProvider.delete(id);
    }

    public List<Dog> getDogs() {
        return mockDogProvider.getDogs();
    }

    public Dog getDogById(long id) {
        return mockDogProvider.findDogById(id);
    }
}
