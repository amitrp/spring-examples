package com.amitph.spring.naming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ShapeService {

    @Autowired
    private Shape circle;

    @Autowired
    private Shape rectangle;

    @Autowired
    private Shape squareType;

    @Autowired
    private Shape triangleShape;

    @Autowired
    private Shape pentagonShape;

    @Autowired
    @Qualifier("heartBean")
    private Shape heartShape;

    @PostConstruct
    public void afterStartup() {
        assert circle instanceof Circle;
        assert rectangle instanceof Rectangle;
        assert triangleShape instanceof Triangle;
        assert squareType instanceof Square;
        assert pentagonShape instanceof Pentagon;
        assert heartShape instanceof Heart;
    }
}