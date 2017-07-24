package org.cx.lock;

public class SynchronizedDemo {

  Student stu = new Student();
  
  /**
   * 用在实例上， 实例锁
   */
  public synchronized void someMethod() {
    
  }
  
  /**
   * 静态方法上，类锁
   */
  public static synchronized void someMethod2() {
    
  }
  
  public void someMethod3() {
    //表达式是实例，则为实例锁，同一个实例才互斥
    synchronized(stu) {
    }
    
    //this 实例锁
    synchronized (this) {
    }

    //类锁,lockDemo所有实例都会互斥
    synchronized (SynchronizedDemo.class) {
    }
  }
}
