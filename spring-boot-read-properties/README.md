# Reading Properties in Spring Boot using @ConfigurationProperties
_Covers a different examples of reading and binding properties file or yaml file configurations in a Java Class._ 

## This repository is part of [amitph.com](https://www.amitph.com/) tutorials.
> - [Using @ConfigurationProperties in Spring Boot](https://www.amitph.com/)

## Examples

### Reading Simple Properties File
- [SimpleProperties.java](/src/main/java/com/amitph/spring/properties/SimpleProperties.java)

### Reading properties subsets using `prefix` attribute
- [UserServiceProperties.java](/src/main/java/com/amitph/spring/properties/prefixed/UserServiceProperties.java)
- [LoginServiceProperties.java](/src/main/java/com/amitph/spring/properties/prefixed/LoginServiceProperties.java)

## Binding properties of a different names
- [DifferentlyNamedProperties.java](/src/main/java/com/amitph/spring/properties/prefixed/DifferentlyNamedProperties.java)

## Setter Injected and Constructor Injected Properties
- [SetterBasedLoginProperties.java](/src/main/java/com/amitph/spring/properties/SetterBasedLoginProperties.java)
- [ConstructorBasedLoginProperties.java](/src/main/java/com/amitph/spring/properties/ConstructorBasedLoginProperties.java)


## How to Run

### Git Checkout
```
~ git clone https://github.com/amitrp/spring-examples.git
~ cd spring-examples/spring-boot-read-properties
```

### Launch application
```
~ mvn spring-boot:run
```  

