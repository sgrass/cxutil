package org.cx.designpattern.proxy;

public class Client {

  public static void main(String[] args) {
    Subject proxy = new ProxySubject(new RealSubject()); 
    proxy.dealTask("DBQueryTask");  
  }

}
