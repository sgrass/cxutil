package org.cx.designpattern.proxy.dynamic;

import org.cx.designpattern.proxy.Subject;

public class Client {

  public static void main(String[] args) {
    Subject proxy = DynProxyFactory.getInstance();  
    proxy.dealTask("DBQueryTask");  
  }

}
