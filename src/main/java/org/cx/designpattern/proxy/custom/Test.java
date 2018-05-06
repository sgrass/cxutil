package org.cx.designpattern.proxy.custom;

import org.cx.designpattern.proxy.dynamic.UserService;
import org.cx.designpattern.proxy.dynamic.UserServiceImpl;

/**
 * @author grass
 * @date 2018/5/6
 */
public class Test {
    public static void main(String[] args) throws Exception {
        /**
         *  Person obj = (Person)new CustomMeipo().getInstance(new XieMu());
         System.out.println(obj.getClass());
         obj.findLove();

         */
        UserService service = (UserService) new ServiceProxy().getInstance(new UserServiceImpl());
        System.out.println(service.getClass());
        service.saveUser();
    }
}
