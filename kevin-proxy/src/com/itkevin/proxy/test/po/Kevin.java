package com.itkevin.proxy.test.po;

import com.itkevin.proxy.test.Person;

public class Kevin implements Person {
    @Override
    public void getSay() {
        System.out.println("这是接口实现类中的方法处理");
    }
}
