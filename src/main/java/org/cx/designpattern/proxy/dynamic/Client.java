package org.cx.designpattern.proxy.dynamic;

import java.io.FileOutputStream;
import java.io.IOException;

public class Client {

  public static void main(String[] args) {
    UserService service=(UserService) new ServiceProxy().getProxy(new UserServiceImpl());
    service.saveUser();


    /**
     * 1、拿到被代理对象的引用，并且获取到它的所有的接口，反射获取
     * 2、JDK Proxy类重新生成一个新的类、同时新的类要实现被代理类所有实现的所有的接口
     * 3、动态生成Java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
     * 4、编译新生成的Java代码.class
     * 5、再重新加载到JVM中运行
     * 以上这个过程就叫字节码重组
     * JDK规范，只要要是$开头的一般都是自动生成的
     *
     */

    /*try {
      byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{UserService.class});
      FileOutputStream os = new FileOutputStream("$Proxy0.class");
      os.write(bytes);
      os.close();
    } catch (IOException e) {
      e.printStackTrace();
    }*/


  }

}
