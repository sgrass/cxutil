package org.cx.designpattern.strategy;

/**
 * 枚举策略模式
 * @author grass
 * @date 2018/4/15
 */
public enum StrategyEnumDemo {
    ADD {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },

    SUBTRACT {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    };

    public abstract int calculate(int a, int b);

    public static void main(String[] args) {
        int addResult = StrategyEnumDemo.ADD.calculate(1, 2);
        System.out.println(addResult);

        int subResult = StrategyEnumDemo.SUBTRACT.calculate(1, 2);
        System.out.println(subResult);

    }

}
