package org.cx.designpattern.factory.abstractfactory;

/**
 * 工厂模式只负责创建对象
 * @author grass
 */
public abstract class AbstractFactory {
    public abstract Java jdImpl();

    public abstract Java taobaoImpl();

    public abstract Java baiduImpl();
}
