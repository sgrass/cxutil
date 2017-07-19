package org.cx.designpattern.proxy.dynamic;

public class UserServiceImpl implements UserService {

  @Override
  public void saveUser() {
    System.out.println("save user ...");
  }

}
