package org.cx.designpattern.signleton;

import org.springframework.context.annotation.Lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 避免{@link Signleton2}的性能问题，也不存在{@link Signleton1}的内存浪费
 *
 * 在外部类被调用的时候内部类才会被加载
 * 内部类一定要在方法调用之前初始化，避免线程安全问题
 * @author grass
 */
public class Signleton3 {
    //若通过反射改变flag的值，则构造方法中的判断无效。可修改为内部类避免
    private static boolean flag = false;

    private Signleton3() {
        /**
         * 此段代码避免反射入侵
         */
        synchronized (Signleton3.class) {
            if (flag == false) {
                flag = !flag;
            } else {
                throw new RuntimeException("单例被侵犯");
            }
        }
    }

    public static final Signleton3 getInstance() {
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder {
        public static final Signleton3 LAZY = new Signleton3();
    }


    public static void main(String[] args) {
        /**
         * 测试反射入侵单例
         */
        Class clazz = Signleton3.class;
        try {
            Constructor constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object obj1 = constructor.newInstance();
            Object obj2 = constructor.newInstance();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
