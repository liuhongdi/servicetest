package com.servicetest.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello(String name) {
        return "您好,"+name+"!";
    }

    public int addTwo(int first,int second) {
        return first+second;
    }
}
