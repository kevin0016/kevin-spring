package com.itkevin.factory.test.po;

import com.itkevin.factory.test.Car;

public class Audi implements Car {
    @Override
    public String getName() {
        return "Audi";
    }
}
