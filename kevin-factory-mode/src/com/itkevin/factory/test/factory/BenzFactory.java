package com.itkevin.factory.test.factory;

import com.itkevin.factory.test.Car;
import com.itkevin.factory.test.po.Benz;

public class BenzFactory  extends AbstractFactory{
    @Override
    public Car getCar() {
        return new Benz();
    }
}
