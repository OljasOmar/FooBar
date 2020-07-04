package com.oljas.foobarProj.Service;

import com.oljas.foobarProj.model.FooBarCollection;
import com.oljas.foobarProj.model.FooBarGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Component
@Service
public class FooBarService {
    @Autowired
    FooBarCollection fooBarCollection;

    private String result;
    private Long l;

    public void setLong(Long num) {
        this.l = num;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getLong() {
        return l;
    }

    @NonNull
    @ExceptionHandler
    public String buildString(Long number) {

        // Remove leading 0
        String stringLong = number.toString().replaceFirst("^0+(?!$)", "");
        number = Long.parseLong(stringLong);


        List<FooBarGenerator> list = fooBarCollection.formList();
        StringBuilder builder = new StringBuilder();

        for (FooBarGenerator m: list) {
            if (number%m.getKey() == 0) {
                builder.append(m.getValue());
            }
        }

        list.clear();

        if (builder.length() < 1) {
            result = "No result";
        } else {
            result = builder.toString();
        }

        return result;
    }

    public String getResult() {
        return result;
    }
}
