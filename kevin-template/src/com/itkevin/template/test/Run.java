package com.itkevin.template.test;

import org.junit.Test;

/**
 * 模板设计模式
 * 执行流程一样，但中间有些步骤不同
 */
public class Run {

    @Test
    public void test1(){
        Coffee coffee = new Coffee();
        coffee.create();
    }

    //SpringJDBC
    //是java规范，各个数据库厂商自己去实现 j2EE规范就是个模板，根据这个模板来实现JAVAEE开发
    //1、加载驱动类DriverManager
    //2、建立连接
    //3、创建语句集(标准语句集、预处理语句集)(语句集？  MySQL、Oracle、SQLServer、Access)
    //4、执行语句集
    //5、结果集ResultSet 游标
    //ORM(?)


}
