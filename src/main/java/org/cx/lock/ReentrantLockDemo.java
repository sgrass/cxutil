package org.cx.lock;

import java.util.concurrent.locks.ReentrantLock;


/**
 *
 * ReentrantLock是基于AQS实现的
 * 在AQS内部会保存一个状态变量state，通过CAS修改该变量的值，修改成功的线程表示获取到该锁，
 * 没有修改成功，或者发现状态state已经是加锁状态，则通过一个Waiter对象封装线程，添加到等待队列中，并挂起等待被唤醒
 * {@link java.util.concurrent.locks.AbstractQueuedSynchronizer#acquire}
 *
 * CAS参数,第一个参数是要修改的对象，第二个参数是对象中要修改变量的偏移量，第三个参数是修改之前的值，第四个参数是预想修改后的值
 *
 * CAS存在ABA问题,{@AtomicStampedReference} 或者 {@link java.util.concurrent.locks.StampedLock} 解决
 *
 * 公平锁:
 *  static final class FairSync extends Sync 每个线程的资源竞争是公平的.按照自身线程调用lock方法的顺序来获取锁,即先到先得.
 * 非公平锁:
 *  static final class NonfairSync extends Sync 每个线程的资源竞争是顺序不定,谁的优先级高,那么谁就会先获得锁.
 * 无参构造方法默认将局部变量sync赋值为NonfairSycn
 *
 * acquire(1)一般参数为0是释放锁,参数为1是获取锁
 *
 *
 * 使用reentrantLock的场景
 *  1.可以指定是公平锁还是非公平锁。而synchronized只能是非公平锁。所谓的公平锁就是先等待的线程先获得锁。
 *  2.提供了一个Condition（条件）类，用来实现分组唤醒需要唤醒的线程们，而不是像synchronized要么随机唤醒一个线程要么唤醒全部线程。
 *  3.提供了一种能够中断等待锁的线程的机制，通过lock.lockInterruptibly()来实现这个机制。
 *
 *
 * 支持锁中断防止死锁，优先响应中断
 * 支持限时获取锁
 * @author grass
 *
 */
public class ReentrantLockDemo implements Runnable {

  private static final Student stu = new Student();
  
  //定义为静态，即为类锁
  private static ReentrantLock reentrantLock = new ReentrantLock();
  
  
  @Override
  public void run() {
    for (int i=0; i<10000; i++) {
      try {
        reentrantLock.lock();
        increase();
      } finally {
        reentrantLock.unlock();
      }
    }
  }
  
  private void increase() {
      int id = stu.getId();
      id++;
      stu.setId(id);
  }
  
  public static void main(String[] args) {
    ReentrantLockDemo lock1 = new ReentrantLockDemo();
    ReentrantLockDemo lock2 = new ReentrantLockDemo();
    
    Thread thread1 = new Thread(lock1);
    Thread thread2 = new Thread(lock2);
    
    thread1.start();
    thread2.start();
    
    
    try {
      //等待子现成完成
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    System.out.println(stu.getId());
  }

}
