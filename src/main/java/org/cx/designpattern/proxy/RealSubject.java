package org.cx.designpattern.proxy;

public class RealSubject implements Subject {

  @Override
  public void dealTask(String taskName) {
    System.out.println("真实的操作类"+taskName);
  }

}
