package org.cx.spi;

/**
 * @author grass
 * @date 2018/1/5
 */
public class HelloServiceEnImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("hello world.....");
    }
}
