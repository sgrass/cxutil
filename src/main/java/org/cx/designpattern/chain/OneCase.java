package org.cx.designpattern.chain;

/**
 * @author grass
 * @date 2019/7/9
 */
public class OneCase implements BaseCase {
    @Override
    public void doSomething(String input, BaseCase baseCase) {
        if ("1".equals(input)) {
            System.out.println(getClass().getName());
            return;
        }
        //当前没法处理，回调回去，让下一个去处理
        baseCase.doSomething(input, baseCase);
    }
}
