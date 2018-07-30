package org.cx.designpattern.decotrator.test;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * @author grass
 */
public class DecoratorTest {
    public static void main(String[] args) {
        /**
         * 为了某个实现类在不修改原始类的基础上进行动态地覆盖或者增加方法。适配器模式只是兼容没有覆盖或扩展
         * 该实现保持跟原有类的层级关系
         * 采用装饰模式
         * 装饰器模式实际上一种非常特殊的适配器模式
         *
         * 虽然 DataInputStream 功能更强大
         * DataInputStream 同样要实现InputStream
         *
         * spring中decorator和wrapper都是装饰器
         */

        InputStream in = System.in;
        FilterInputStream filterInputStream = new DataInputStream(in);

    }
}
