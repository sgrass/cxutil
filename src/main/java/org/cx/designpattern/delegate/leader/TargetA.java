package org.cx.designpattern.delegate.leader;

/**
 * @author grass
 */
public class TargetA implements ITarget {
    @Override
    public void doing(String command) {
        System.out.println("员工A，现在开始干" + command + "工作");
    }
}
