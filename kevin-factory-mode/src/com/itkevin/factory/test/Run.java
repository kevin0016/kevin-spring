package com.itkevin.factory.test;

import com.itkevin.factory.test.factory.*;
import org.junit.Test;

public class Run {
    /**
     * 简单工厂
     */
    @Test
    public void simpleFactoryTest(){
        SimpleFactory simpleFactory = new SimpleFactory();
        Car car = simpleFactory.getCar("");
        System.out.println(car.getName());
    }

    /**
     * 抽象工厂
     */
    @Test
    public void factoryTest(){
        DefaultFactory factory = new DefaultFactory();
        System.out.println(factory.getCar("Benz").getName());
    }
}
