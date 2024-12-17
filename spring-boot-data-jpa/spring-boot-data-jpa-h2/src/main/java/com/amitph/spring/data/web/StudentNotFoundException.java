package com.amitph.spring.data.web;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {}
