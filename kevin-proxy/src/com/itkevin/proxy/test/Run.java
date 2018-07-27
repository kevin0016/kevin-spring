package com.itkevin.proxy.test;

import com.itkevin.proxy.test.cglib.CglibProxy;
import com.itkevin.proxy.test.jdk.BeanProxy;
import com.itkevin.proxy.test.kevin.KevinBeanProxy;
import com.itkevin.proxy.test.po.Kevin;
import org.junit.Test;

public class Run {

    /**
     * jdk中的代理
     * 原理：
     * 		1.拿到被代理对象的引用，然后获取它的接口
     * 		2.JDK代理重新生成一个类，同时实现我们给的代理对象所实现的接口
     * 		3.把被代理对象的引用也拿到了
     * 		4.重新动态生成一个class字节码
     * 		5.然后编译
     */
    @Test
    public void jdkTest() {
        try {
            //创建代理对象
            Person obj = (Person) new BeanProxy().getInstance(new Kevin());
            System.out.println("代理对象的class是："+obj.getClass());
            //执行代理对象中的方法
            obj.getSay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 我们自己创建的代理
     * 满足代理模式应用场景的三个必要条件，穷取法
     *  1、两个角色，执行者，被代理对象
     *  2、注重过程，必须要做，被代理对象没有时间做或者不想做，不专业
     *  3、执行者必须拿到被代理对象的信息资料（执行者持有被代理对象的引用）
     */
    @Test
    public void kevinTest() {
        try {
            //创建代理对象
            Person obj = (Person) new KevinBeanProxy().getInstance(new Kevin());
            System.out.println("代理对象的class是："+obj.getClass());
            //执行代理对象中的方法
            obj.getSay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @Test
    public void cglibTest() {
        try {
            //创建代理对象
            Person obj = (Person) new CglibProxy().getInstance(new Kevin().getClass());
            System.out.println("代理对象的class是："+obj.getClass());
            //执行代理对象中的方法
            obj.getSay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
