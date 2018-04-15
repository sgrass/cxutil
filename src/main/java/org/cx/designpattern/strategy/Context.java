package org.cx.designpattern.strategy;

/**
 * 策略模式 开闭原则 可扩展不可修改
 * @author grass
 * @date 2018/4/15
 */
public class Context {
    private Strategy stratedy;

    public Context(Strategy stratedy) {
        this.stratedy = stratedy;
    }

    public int execute(int i, int j) {
        return stratedy.calculate(i, j);
    }
}
