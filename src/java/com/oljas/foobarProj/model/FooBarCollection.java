package com.oljas.foobarProj.model;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FooBarCollection {

    List<FooBarGenerator> list = new ArrayList<>();

    public List<FooBarGenerator> getList() {
        return list;
    }

    public List<FooBarGenerator> formList(){
        list.add(new FooBarGenerator(3L, "foo"));
        list.add(new FooBarGenerator(5L, "bar"));
        list.add(new FooBarGenerator(7L, "boo"));

        return list;
    }
}
