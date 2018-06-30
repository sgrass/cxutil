package org.cx.designpattern.decotrator.passport.old;


/**
 * @author grass
 */
public class SigninServiceImpl implements SigninService {
    @Override
    public ResultMsg regist(String username, String password) {
        return  new ResultMsg(200,"注册成功",new Member());
    }

    @Override
    public ResultMsg login(String username, String password) {
        return null;
    }
}
