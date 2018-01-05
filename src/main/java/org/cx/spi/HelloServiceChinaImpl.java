package org.cx.spi;

/**
 * @author grass
 * @date 2018/1/5
 */
public class HelloServiceChinaImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("你好....");
    }
}
