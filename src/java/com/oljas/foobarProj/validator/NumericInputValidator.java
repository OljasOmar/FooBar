package com.oljas.foobarProj.validator;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class NumericInputValidator implements InputValidator<Long> {
    private boolean notvalid;

    public void setNotvalid(boolean notvalid) {
        this.notvalid = notvalid;
    }

    // validate input number
    @Override
    public void validate(@NonNull Long input) {

        if (input == 0) {
            throw new IllegalArgumentException("Can not process 0");
        }

        if (input < 0) {
            throw new IllegalArgumentException("Can not process negative values");
        }
    }

    public boolean isNotvalid() {
        return notvalid;
    }
}