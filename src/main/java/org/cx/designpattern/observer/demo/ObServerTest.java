package org.cx.designpattern.observer.demo;

import java.lang.reflect.Method;

/**
 * @author grass
 * @date 2018/5/13
 */
public class ObServerTest {
    public static void main(String[] args) throws NoSuchMethodException {

        Observer observer = new Observer();
        Method advice = Observer.class.getMethod("advice", new Class<?>[]{Event.class});


        //这里写Lily
        Subject subject = new Subject();
        subject.addLisenter(SubjectEventType.ON_ADD,observer,advice);
        subject.addLisenter(SubjectEventType.ON_EDIT,observer,advice);
        subject.addLisenter(SubjectEventType.ON_RMOVE,observer,advice);
        subject.addLisenter(SubjectEventType.ON_QUERY,observer,advice);

        subject.add();
        subject.remove();


    }
}
