package org.cx.designpattern.factory.abstractfactory;

/**
 * @author grass
 */
public class JavaFactory extends AbstractFactory {
    @Override
    public Java jdImpl() {
        return new JdImpl();
    }

    @Override
    public Java taobaoImpl() {
        return new TaobaoImpl();
    }

    @Override
    public Java baiduImpl() {
        return new BaiduImpl();
    }
}
