package org.cx.serial.simple;

import sun.jvm.hotspot.oops.FieldType;

import java.io.Serializable;

/**
 * @author grass
 * @date 2017/10/29
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -3820231825416706579L;

    public static int height = 1;

    private transient String name;

    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
