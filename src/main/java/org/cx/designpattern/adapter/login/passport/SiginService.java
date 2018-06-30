package org.cx.designpattern.adapter.login.passport;

import org.cx.designpattern.adapter.login.vo.Member;
import org.cx.designpattern.adapter.login.vo.ResultMsg;

/**
 * @author grass
 */
public class SiginService {

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username, String password){
        return  new ResultMsg(200,"注册成功",new Member());
    }


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){
        return null;
    }

}
