package com.amitph.spring.exitcode;

import org.springframework.boot.ExitCodeGenerator;

public class ValueTooSmallException
        extends RuntimeException
        implements ExitCodeGenerator {

    public ValueTooSmallException(String msg) {
        super(msg);
    }

    @Override
    public int getExitCode() {
        return 40;
    }
}