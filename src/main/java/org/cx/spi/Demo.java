package org.cx.spi;

import org.cx.io.socket.Server;

import java.util.ServiceLoader;

/**
 * spi处理
 *  1.声明接口
 *  2.实现接口,并在resources目录下新增/META-INF/services目录,新建以接口全路径名的文件org.cx.spi.HelloService,文件包含实现类全路径
 *  3.ServiceLoader加载
 *
 * mysql驱动包中同样实现方式
 *
 * dubbo中修改资源文件增加前缀的处理如 tomcat=org.cx.HelloService
 *
 * spring中使用 spring.factories文件处理
 *
 * @author grass
 * @date 2018/1/5
 */
public class Demo {

    public static void main(String[] args) {

        ServiceLoader<HelloService> serviceLoader = ServiceLoader.load(HelloService.class);

        for (HelloService helloService : serviceLoader) {
            helloService.sayHello();
        }
    }
}
