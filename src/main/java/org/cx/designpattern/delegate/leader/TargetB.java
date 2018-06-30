package org.cx.designpattern.delegate.leader;

/**
 * @author grass
 */
public class TargetB implements ITarget {
    @Override
    public void doing(String command) {
        System.out.println("员工B，现在开始干" + command + "工作");
    }
}
