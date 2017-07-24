package org.cx.lock;

import java.util.concurrent.locks.ReentrantLock;


/**
 * 
 * 重入锁不会阻塞(同步块会阻塞)
 * 可以反复进入
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
