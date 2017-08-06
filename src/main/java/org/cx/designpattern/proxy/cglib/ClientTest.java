package org.cx.designpattern.proxy.cglib;

import org.cx.designpattern.proxy.dynamic.UserServiceImpl;

public class ClientTest {

  public static void main(String[] args) {
    CglibProxy cp = new CglibProxy();
    UserServiceImpl us = (UserServiceImpl) cp.getInstance(UserServiceImpl.class);
    
    us.saveUser();
  }

}
