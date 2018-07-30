package org.cx.designpattern.adapter.login.passport;

import org.cx.designpattern.adapter.login.vo.ResultMsg;

/**
 * @author grass
 */
public class SiginForThirdService extends SiginService {

    public ResultMsg loginForQQ(String openId){
        //注册（在原有系统里面创建一个用户）

        //调用原来的登录方法

        return loginForRegist(openId,null);
    }

    public ResultMsg loginForWechat(String openId){
        return null;
    }

    public ResultMsg loginForToken(String token){
        //通过token拿到用户信息，然后再重新登陆了一次
        return  null;
    }

    public ResultMsg loginForTelphone(String telphone,String code){

        return null;
    }

    public ResultMsg loginForRegist(String username,String password){
        super.regist(username,null);
        return super.login(username,null);
    }

}
