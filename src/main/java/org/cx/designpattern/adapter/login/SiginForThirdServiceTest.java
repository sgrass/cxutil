package org.cx.designpattern.adapter.login;

import org.cx.designpattern.adapter.login.passport.SiginForThirdService;

/**
 * @author grass
 */
public class SiginForThirdServiceTest {
    public static void main(String[] args) {
        SiginForThirdService service = new SiginForThirdService();

        //不改变原来的代码，也要能够兼容新的需求
        //可以再加一层策略模式
        service.loginForQQ("123f2edsfrw5342");

    }
}
