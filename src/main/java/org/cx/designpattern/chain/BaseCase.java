package org.cx.designpattern.chain;

/**
 * @author grass
 * @date 2019/7/9
 */
public interface BaseCase {
    //所有 case 处理逻辑的方法
    void doSomething(String input, BaseCase baseCase);
}
