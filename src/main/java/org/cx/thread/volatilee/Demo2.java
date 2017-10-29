package org.cx.thread.volatilee;

/**
 * @author grass
 * @date 2017/10/29
 */
public class Demo2 {
    int a=0;

    boolean flag = true;

    /**
     * 重排序分 编译重排序和运行重排序
     *
     * 线程t1可能会进行重排序
     * 执行flag==true,但还未设置a=1
     * 接着线程t2读到flag为true但a=0
     *
     * 也可能优先执行了a*a，然后存储在临时变量temp中，flag为true时直接获取temp值
     */
    private void write() {
        a=1;
        flag = true;
    }

    private void read() {
        if (flag) {
            int i = a*a;
        }
    }

    public static void main(String[] args) {
        Demo2 d = new Demo2();
        Thread t1 = new Thread(()->{
            d.write();
        });

        Thread t2 = new Thread(()->{
            d.read();
        });

        t1.start();
        t2.start();

        //可能是0 可能是1
        System.out.println(d.a);

    }
}
