package org.framework.test.aop.service;

public class WorldServiceWithExceptionImpl implements WorldService {
    @Override
    public void explode() {
        System.out.println("The Earth is going to explode with an Exception");
        throw new RuntimeException();
    }
}