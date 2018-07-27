package com.itkevin.proxy.test.jdk;

import com.itkevin.proxy.test.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanProxy implements InvocationHandler {

    private Person target;

    //获取被代理人的个人资料
    public Object getInstance(Person target)throws Exception{
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("被代理的class是："+clazz);
        //通过反射的方式进行处理，返回被代理的对象
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这里是调用被代理的对象前的处理");
        System.out.println("============================");
        method.invoke(this.target,args);
        System.out.println("============================");
        System.out.println("这是调用被代理的对象后的处理");
        return null;
    }
}
