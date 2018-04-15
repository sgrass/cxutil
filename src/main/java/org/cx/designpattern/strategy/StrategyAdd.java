package org.cx.designpattern.strategy;

/**
 * @author grass
 * @date 2018/4/15
 */
public class StrategyAdd implements Strategy {
    @Override
    public int calculate(int i, int j) {
        return i+j;
    }
}
