package com.itkevin.factory.test.factory;

import com.itkevin.factory.test.Car;
import com.itkevin.factory.test.po.Bmw;

public class BmwFactory  extends AbstractFactory{
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
