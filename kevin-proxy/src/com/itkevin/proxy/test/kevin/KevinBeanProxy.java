package com.itkevin.proxy.test.kevin;

import com.itkevin.proxy.test.Person;
import com.itkevin.proxy.test.po.Kevin;

import java.lang.reflect.Method;

public class KevinBeanProxy implements KevinInvocationHandler {

    private Person target;

    public Object getInstance(Person target) {
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("被代理的class是："+clazz);
        //通过反射的方式进行处理，返回被代理的对象
        return KevinProxy.newProxyInstance(new KevinClassloader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这里是Kevin自己的代理类调用被代理的对象前的处理");
        System.out.println("============================");
        method.invoke(this.target,args);
        System.out.println("============================");
        System.out.println("这是Kevin自己的代理类调用被代理的对象后的处理");
        return null;
    }


}
