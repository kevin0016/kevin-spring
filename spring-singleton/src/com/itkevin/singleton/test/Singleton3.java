package com.itkevin.singleton.test;

/**
 * 饿汉模式，无线程安全问题
 * not lazy loading比较常用的方式
 */
public class Singleton3 {
    private static Singleton3 instance = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return instance;
    }
}
