package com.itkevin.delegate.test;

import org.junit.Test;

/**
 * 委派模式
 * 1、类似于中介的功能，（委托机制）
 * 2、持有被委托人的引用
 * 3、不关心过程，只关心结果
 * spring IOC容器种有一个Register的东西（告诉容器在这个类被初始化的过程中，需要做很多不同的逻辑处理，需要实现多个任务执行者，分别实现各自的功能）
 * 与工厂模式区别：保证结果的多样性，对于用户来说只有一种方法
 */
public class Run {

    @Test
    public void test1(){
        ExextorA exextorA = new ExextorA();
        Dispacher dispacher = new Dispacher(exextorA);
        dispacher.doing();
    }
}
