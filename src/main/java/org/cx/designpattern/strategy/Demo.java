package org.cx.designpattern.strategy;

/**
 * @author grass
 * @date 2018/4/15
 */
public class Demo {
    public static void main(String[] args) {
        Context context = new Context(new StrategyAdd());
        int r1 = context.execute(1, 5);
        context = new Context(new StrategySub());
        int r2 = context.execute(5, 3);

        System.out.println(r1);
        System.out.println(r2);
    }
}
