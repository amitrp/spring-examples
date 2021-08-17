# Reading Properties in Spring Boot using @ConfigurationProperties

_Covers a different examples of reading and binding properties file or yaml file configurations in a Java Class._

## This repository is part of [amitph.com](https://www.amitph.com/) tutorials.

> - Using @ConfigurationProperties in Spring Boot
> - Reading Nested Properties in Spring Boot
> - YAML to Map with Spring Boot
> - YAML to Java List of Objects in Spring Boot
> - Validations with @ConfigurationProperties in Spring Boot

## Examples

#### Reading Simple Properties File

- [SimpleProperties.java](src/main/java/com/amitph/spring/properties/SimpleProperties.java)

#### Reading properties subsets using `prefix` attribute

- [UserServiceProperties.java](src/main/java/com/amitph/spring/properties/prefixed/UserServiceProperties.java)
- [LoginServiceProperties.java](src/main/java/com/amitph/spring/properties/prefixed/LoginServiceProperties.java)

#### Binding properties of a different names

- [DifferentlyNamedProperties.java](src/main/java/com/amitph/spring/properties/prefixed/DifferentlyNamedProperties.java)

#### Setter Injected and Constructor Injected Properties

- [SetterBasedLoginProperties.java](src/main/java/com/amitph/spring/properties/SetterBasedLoginProperties.java)
- [ConstructorBasedLoginProperties.java](src/main/java/com/amitph/spring/properties/ConstructorBasedLoginProperties.java)

#### Nested Properties

- [NestedProperties.java](src/main/java/com/amitph/spring/properties/nested/NestedProperties.java)

#### Nested Properties using Java Inner Classes

- [NestedClassesProperties.java](src/main/java/com/amitph/spring/properties/nested/NestedClassesProperties.java)

#### Reading YAML/Properties as Java HashMap

- [MapProperties.java](src/main/java/com/amitph/spring/properties/map/MapProperties.java)

#### YAML/Properties as Java Nested Hashmap or MultiValueMap

- [NestedMapProperties.java](src/main/java/com/amitph/spring/properties/map/NestedMapProperties.java)

#### YAML/Properties as Java plain List

- [PlainListProperties.java](src/main/java/com/amitph/spring/properties/list/PlainListProperties.java)

#### YAML/Properties as Java List of Map

- [ListOfMapProperties.java](src/main/java/com/amitph/spring/properties/list/ListOfMapProperties.java)

#### YAML/Properties as Java List of Objects

- [ListOfObjectProperties.java](src/main/java/com/amitph/spring/properties/list/ListOfObjectProperties.java)

#### Validating Configuration Properties

- [ValidatedProperties.java](src/main/java/com/amitph/spring/properties/validated/ValidatedProperties.java)




## How to Run
```
~ git clone https://github.com/amitrp/spring-examples.git
~ cd spring-examples/spring-boot-read-properties
```

### Launch application
```
~ mvn spring-boot:run
```  

