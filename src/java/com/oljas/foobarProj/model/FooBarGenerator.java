package com.oljas.foobarProj.model;
public class FooBarGenerator {
    private final Long key;

    public FooBarGenerator(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    private final String value;

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
