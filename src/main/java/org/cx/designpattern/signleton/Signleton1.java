package org.cx.designpattern.signleton;

/**
 * 类加载时就立即初始化
 * 没有任何锁 执行效率高
 * 线程出现之前实例已经产生，线程安全
 * 缺点 浪费内存
 * @author grass
 */
public class Signleton1 {
    private Signleton1() {
    }

    public static final  Signleton1 signleton1 = new Signleton1();

    public static Signleton1 getInstance() {
        return signleton1;
    }
}

/**
 * 不浪费内存，synchonized性能问题
 */
class Signleton2 {
    private Signleton2() {

    }

    private static Signleton2 signleton2 = null;

    public static synchronized Signleton2 getInstance() {
        if (signleton2 == null) {
            signleton2 = new Signleton2();
        }
        return signleton2;
    }
}