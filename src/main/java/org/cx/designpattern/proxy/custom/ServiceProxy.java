package org.cx.designpattern.proxy.custom;

import org.cx.designpattern.proxy.dynamic.UserService;

import java.lang.reflect.Method;

/**
 * @author grass
 * @date 2018/5/6
 */
public class ServiceProxy implements MyInvocationHandler {

    private UserService target;

    public Object getInstance(UserService target) throws Exception {
        this.target = target;
        Class<?> clazz = target.getClass();
        return MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.open();
        Object result = method.invoke(this.target, args);
        this.close();
        return result;
    }

    public void open() {
        System.out.println("A:打开数据库连接");
    }

    public void close() {
        System.out.println("B:关闭数据库连接");
    }
}
