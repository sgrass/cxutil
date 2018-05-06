package org.cx.designpattern.proxy.custom;

import java.lang.reflect.Method;

/**
 * @author grass
 * @date 2018/5/6
 */
public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
