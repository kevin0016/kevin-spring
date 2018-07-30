package com.itkevin.factory.test.po;

import com.itkevin.factory.test.Car;

public class Benz implements Car {
    @Override
    public String getName() {
        return "benz";
    }
}
