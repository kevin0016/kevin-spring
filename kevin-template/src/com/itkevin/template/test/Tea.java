package com.itkevin.template.test;

public class Tea extends Beverage {
    @Override
    public void pourInCup() {
        System.out.println("将茶叶放入杯中");
    }

    @Override
    public void addCoundiments() {
        System.out.println("添加蜂蜜");
    }
}
