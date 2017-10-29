package org.cx.serial.parent;

import java.io.Serializable;

/**
 * @author grass
 * @date 2017/10/29
 */
public class Student extends SuperStudent implements Serializable {


    private int aa;

    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "aa=" + aa +
                '}';
    }
}
