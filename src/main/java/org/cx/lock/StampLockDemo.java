package org.cx.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * jdk8 javadoc demo
 *
 * 类似 {@link java.util.concurrent.atomic.AtomicStampedReference} 通过一个版本号，解决ABA问题
 *
 *
 *
 * @author grass
 * @date 2017/11/21
 */
public class StampLockDemo {
    /**
     * 坐标x，y，一个修改，一个读。
     */
    private double x, y;
    private final StampedLock sl = new StampedLock();

    /**
     * 独占锁，写锁，排他性，阻塞读。
     * @param deltaX
     * @param deltaY
     */
    void move(double deltaX, double deltaY) { // an exclusively locked method 完全锁定的方法
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    /**
     * 乐观读，对读共享，对写不排他，允许写。写少读多
     * @return
     */
    double distanceFromOrigin() { // A read-only method
        long stamp = sl.tryOptimisticRead();  //获得一个乐观读锁
        double currentX = x, currentY = y;  //将两个字段读入本地局部变量
        if (!sl.validate(stamp)) {  //检查发出乐观读锁后同时是否有其他写锁发生
            stamp = sl.readLock(); //如果没有，再次获得一个读悲观锁
            try {
                currentX = x; //将两个字段读入本地局部变量
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        //最后执行返回，可以是乐观读后的数据，或者是普通读后的数据。
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }


    /**
     * 普通读锁，对读共享，对写排他， 读少写多
     * @param newX
     * @param newY
     */
    void moveIfAtOrigin(double newX, double newY) { // upgrade
        // Could instead start with optimistic, not read mode
        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0) { //循环，检查当前状态是否符合.没有改成功，就一直阻塞。
                long ws = sl.tryConvertToWriteLock(stamp); //将读锁转为写锁
                if (ws != 0L) { //确认转为写锁是否成功
                    stamp = ws; //如果成功 替换票据
                    x = newX;   //进行状态改变
                    y = newY;
                    break;
                }
                else {
                    //如果不能成功转换为写锁
                    sl.unlockRead(stamp);   //显式释放读锁
                    stamp = sl.writeLock(); //显式直接进行写锁 然后再通过循环再试
                }
            }
        } finally {
            sl.unlock(stamp);   //释放读锁或写锁
        }
    }

}
