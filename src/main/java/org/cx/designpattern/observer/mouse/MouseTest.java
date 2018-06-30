package org.cx.designpattern.observer.mouse;

import org.cx.designpattern.observer.demo.Event;

import java.lang.reflect.Method;

/**
 * @author grass
 * @date 2018/5/13
 */
public class MouseTest {
    public static void main(String[] args) throws NoSuchMethodException {
        MouseEventCallback callback = new MouseEventCallback();
        Method onClick = MouseEventCallback.class.getMethod("onClick", Event.class);


        Mouse mouse = new Mouse();
        mouse.addLisenter(MouseEventType.ON_CLICK, callback, onClick);
        mouse.click();
    }
}
