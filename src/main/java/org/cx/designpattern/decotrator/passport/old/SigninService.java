package org.cx.designpattern.decotrator.passport.old;


/**
 * @author grass
 */
public interface SigninService {
    ResultMsg regist(String username, String password);

    ResultMsg login(String username,String password);

}
