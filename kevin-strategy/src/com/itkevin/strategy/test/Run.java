package com.itkevin.strategy.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 策略设计模式
 * 殊途同归
 * 过程不同，结果相同
 */
public class Run {

    @Test
    public void test1(){
        List<Long> numbers = new ArrayList<>();
        Collections.sort(numbers, (o1, o2) -> 0);
    }
}
