package com.itkevin.proxy.test.kevin;

import java.lang.reflect.Method;

/**
 * 创建我们自己的代理接口
 */
public interface KevinInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
