package org.cx.designpattern.proxy.dynamic;


public class Client {

  public static void main(String[] args) {
    UserService service=(UserService) new ServiceProxy().getProxy(new UserServiceImpl());
    service.saveUser();
  }

}
