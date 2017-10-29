package org.cx.serial.parent;

import java.io.Serializable;

/**
 * @author grass
 * @date 2017/10/29
 */
public class SuperStudent {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SuperStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
