package com.oljas.foobarProj;

import org.springframework.stereotype.Component;

@Component
public class FooBar {

    private String result;
    private int integer;

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getInteger() {
        return integer;
    }

    public String buildString(int integer) {

        result = "";
        if (integer%3 == 0 && integer%5 == 0) {
            result = "foobar";
        } else if (integer%3==0) {
            result = "foo";
        } else if (integer%5==0) {
            result = "bar";
        }

        return result;
    }

    public String getResult() {
        return result;
    }
}
