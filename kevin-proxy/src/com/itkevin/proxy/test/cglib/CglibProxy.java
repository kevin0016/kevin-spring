package com.itkevin.proxy.test.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB是通过继承的方式进行代理，代理类继承需要代理的类，好处是不需要非的有一个接口
 */
public class CglibProxy implements MethodInterceptor {
    public Object getInstance(Class clazz) throws Exception {
        Enhancer enhancer = new Enhancer();
        //告诉CGLIB，生成的子类需要继承哪个类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //1、生成源代码
        //2、编译成class
        //3、加载到JVM中，并返回被代理的对象
        return enhancer.create();
    }

    /**
     * 同样是做了字节码重组这样一件事
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("这里是Kevin自己的代理类调用被代理的对象前的处理");
        System.out.println("============================");
        methodProxy.invokeSuper(o,objects);
        System.out.println("============================");
        System.out.println("这是Kevin自己的代理类调用被代理的对象后的处理");
        return null;
    }
}
