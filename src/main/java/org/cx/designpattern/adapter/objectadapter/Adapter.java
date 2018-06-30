package org.cx.designpattern.adapter.objectadapter;

/**
 * 目的：主要为了兼容老代码
 * 可以继承，也可以引用进来
 */
public class Adapter implements Target {
    public Adapter(Adaptee adaptee) {
        super();
        this.adaptee = adaptee;
    }

    public void sampleOperation1() {
        adaptee.sampleOperation1();
    }

    public void sampleOperation2() {
        // Write your code here
    }

    private Adaptee adaptee;
}
