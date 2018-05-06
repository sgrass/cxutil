package org.cx.designpattern.factory.abstractfactory;

import org.cx.designpattern.factory.abstractfactory.JavaFactory;

/**
 * 抽象工程 开闭原则可扩展不可修改
 *
 * @author grass
 */
public class Demo {
    public static void main(String[] args) {
        JavaFactory factory = new JavaFactory();

        factory.jdImpl().program();
        factory.taobaoImpl().program();
        factory.baiduImpl().program();
    }
}
