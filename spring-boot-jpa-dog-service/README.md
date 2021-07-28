# Spring Boot + Spring Data JPA Sample (Dogs Service)
This is a Spring Boot RESTful DogService for performing simple CRUD operations on Dog

## This repository is part of [amitph.com](https://www.amitph.com) tutorials.
> The dogs-service-jpa will be used as a Source Code example for:
> - **[Spring Data and JPA Tutorial](https://www.amitph.com/spring-data-and-jpa-tutorial/)**
> - **[Wildcard Queries with Spring Data JPA](https://www.amitph.com/spring-data-and-jpa-tutorial/)**
> - **[Spring Boot Runners – Application Runner and Command Line Runner](https://www.amitph.com/spring-boot-runners/)**

## Spring Data JPA Repository Implementations
- [DogsRepository.java](src/main/java/com/amitph/spring/dogs/repo/DogsRepository.java): Simple CRUD Repository to perform basic operations on Dog table.
- [DogsRepositoryWildcardWithQuery.java](src/main/java/com/amitph/spring/dogs/repo/DogsRepositoryWildcardWithQuery.java): Example of executing wildcard queries (LIKE, NOT LIKE, Starts With, Ends With) using @Query annotation.
- [DogsRepositoryWildcardWithQueryMethods.java](src/main/java/com/amitph/spring/dogs/repo/DogsRepositoryWildcardWithQueryMethods.java): Example of performing wildcard searches  (LIKE, NOT LIKE, Starts With, and Ends With) using Spring Data JPA Query methods.

## Spring Boot Runner Implementations
- [ApplicationRunnerImpl.java](src/main/java/com/amitph/spring/dogs/ApplicationRunnerImpl.java)
- [CommandLineRunnerImpl.java](src/main/java/com/amitph/spring/dogs/CommandLineRunnerImpl.java)

## How to Run

### Git Checkout
```
~ git clone https://github.com/amitrp/spring-examples.git
~ cd spring-examples/spring-boot-jpa-dog-service
```

### To launch a MySQL instance (Optional)
```
~ docker-compose -f docker/docker-compose.yml up -d
```

### Launch application
```
~ mvn spring-boot:run
```  
