package org.cx.serial.clone;

import java.io.Serializable;

/**
 * @author grass
 * @date 2017/10/29
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 632935712096053862L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }
}
