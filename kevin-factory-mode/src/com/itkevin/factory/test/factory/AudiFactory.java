package com.itkevin.factory.test.factory;

import com.itkevin.factory.test.Car;
import com.itkevin.factory.test.po.Audi;

public class AudiFactory extends AbstractFactory{
    @Override
    public Car getCar() {

        return new Audi();
    }
}
