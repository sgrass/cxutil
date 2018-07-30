package org.cx.designpattern.decotrator.passport.upgrade;

import org.cx.designpattern.decotrator.passport.old.ResultMsg;
import org.cx.designpattern.decotrator.passport.old.SigninService;

/**
 * @author grass
 * @date 2018/5/12
 */
public class SigninForThirdServiceImpl implements SigninForThirdService {

    private SigninService service;

    public SigninForThirdServiceImpl(SigninService service) {
        this.service = service;
    }

    @Override
    public ResultMsg loginForQQ(String openId) {
        //1、openId是全局唯一，我们可以把它当做是一个用户名(加长)
        //2、密码默认为QQ_EMPTY
        //3、注册（在原有系统里面创建一个用户）

        //4、调用原来的登录方法
        return loginForRegist(openId,null);
    }

    @Override
    public ResultMsg loginForWechat(String openId) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return null;
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String username, String password) {
        this.regist(username,null);
        return this.login(username,null);

    }

    @Override
    public ResultMsg regist(String username, String password) {
        return service.regist(username,password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return service.login(username,password);
    }
}
