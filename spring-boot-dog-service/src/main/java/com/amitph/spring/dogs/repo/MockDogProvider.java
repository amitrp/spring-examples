package com.amitph.spring.dogs.repo;

import com.amitph.spring.dogs.model.DogDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockDogProvider {
    private List<Dog> mockDogStore;

    public MockDogProvider() {
        mockDogStore = new ArrayList<>();
        mockDogStore.add(Dog.of(1, "Benji", 10));
        mockDogStore.add(Dog.of(2, "Baxter", 9));
        mockDogStore.add(Dog.of(3, "Brinkley", 8));
        mockDogStore.add(Dog.of(4, "Daisy", 10));
        mockDogStore.add(Dog.of(5, "Cujo", 12));
    }

    public List<Dog> getDogs() {
        return mockDogStore;
    }

    public Dog findDogById(long id) {
        for (Dog dog : mockDogStore) {
            if (dog.getId() == id) {
                return dog;
            }
        }
        return null;
    }

    public void add(DogDto dto) {
        mockDogStore.add(Dog.of(dto.getId(), dto.getName(), dto.getAge()));
    }

    public void delete(long id) {
        int idxToDelete = -1;
        for (int idx = 0; idx < mockDogStore.size(); idx++) {
            if (mockDogStore.get(idx).getId() == id) {
                idxToDelete = idx;
                break;
            }
        }
        if (idxToDelete != -1) mockDogStore.remove(idxToDelete);
    }
}