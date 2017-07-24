package org.cx.lock;

public class SynchronizedDemo2 implements Runnable{
  
  private static final Student stu = new Student();

  @Override
  public void run() {
    for (int i=0; i<10000; i++) {
      increase();
    }
  }

  /**
   * 方法加上statis 变为类锁
   */
//  private static synchronized void increase() {
//    int id = stu.getId();
//    id++;
//    stu.setId(id);
//  }
  
  /**
   * synchronized (this)  实例锁 
   * 
   * synchronized (LockDemo2.class) 类锁，作用在类上面
   */
  private void increase() {
    synchronized (SynchronizedDemo2.class) {
      int id = stu.getId();
      id++;
      stu.setId(id);
    }
  }
  
  public static void main(String[] args) {
    SynchronizedDemo2 lock = new SynchronizedDemo2();
    SynchronizedDemo2 lock1 = new SynchronizedDemo2();
    Thread thread1 = new Thread(lock);
    Thread thread2 = new Thread(lock1);
    
    thread1.start();
    thread2.start();
    
    
    try {
      //等待子线程完成
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    System.out.println(stu.getId());
  }
}
