package ru;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {

    private String message;

    public HelloBean(String message) {
        this.message = message;
    }

    public void sayHello() {
        System.out.println(message);
    }
}