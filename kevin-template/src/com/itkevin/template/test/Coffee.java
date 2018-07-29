package com.itkevin.template.test;

public class Coffee extends Beverage {
    @Override
    public void pourInCup() {
        System.out.println("将咖啡倒入杯中");
    }

    @Override
    public void addCoundiments() {
        System.out.println("添加牛奶和糖");
    }
}
