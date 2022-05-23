package com.springboot.fundamentos.bean;

public class MyOperationImplement implements MyOperation {

    @Override
    public int sum(int number) {
        return ++number;
    }
}
