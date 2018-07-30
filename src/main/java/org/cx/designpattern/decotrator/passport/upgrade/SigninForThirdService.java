package org.cx.designpattern.decotrator.passport.upgrade;

import org.cx.designpattern.decotrator.passport.old.ResultMsg;
import org.cx.designpattern.decotrator.passport.old.SigninService;

/**
 * @author grass
 */
public interface SigninForThirdService extends SigninService {

    public ResultMsg loginForQQ(String openId);

    public ResultMsg loginForWechat(String openId);

    public ResultMsg loginForToken(String token);

    public ResultMsg loginForTelphone(String telphone,String code);

    public ResultMsg loginForRegist(String username,String password);

}
